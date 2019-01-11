package com.qfedu.mitu.service.impl;

import com.alibaba.fastjson.JSON;
import com.qfedu.mitu.comment.constant.Constant;
import com.qfedu.mitu.comment.email.EmailUtils;
import com.qfedu.mitu.comment.utils.ConvertUtil;
import com.qfedu.mitu.comment.utils.EncrypUtil;
import com.qfedu.mitu.comment.utils.JedisUtil;
import com.qfedu.mitu.comment.utils.TokenUtil;
import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.comment.vo.ResultUtil;
import com.qfedu.mitu.domain.TLogs;
import com.qfedu.mitu.domain.TUser;
import com.qfedu.mitu.mapper.TLogsMapper;
import com.qfedu.mitu.mapper.TUserMapper;
import com.qfedu.mitu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author : zcg
 * @Data ：Create in 10:152019/1/7
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private TUserMapper userMapper;
    @Autowired
    private TLogsMapper logsMapper;

    @Override
    public Result sendCode(String email, String ip) {
        String handleNum = jedisUtil.getStr(ip);

        //用户号第一次输入邮箱获取验证码
        if (Objects.isNull(handleNum)) {
            int code = new Random().nextInt(999999);
            boolean result = EmailUtils.sendModel(email, code);
            if (result) {
                jedisUtil.addStr(email, code + "", TimeUnit.MINUTES, 5);

            }

            jedisUtil.addStr(ip, 1 + "", TimeUnit.MINUTES, 3);
            return ResultUtil.setOK("验证码发送", null);
        }

        if (Integer.valueOf(handleNum) > Constant.CODESENDNUMBER) {
            return ResultUtil.setOtherERROR("操作频繁");
        }

        //用戶不是第一次也不是規定時間超過3次
        if (Integer.valueOf(handleNum) <= Constant.CODESENDNUMBER) {
            Integer value = Integer.valueOf(handleNum);
            value++;
            int code = new Random().nextInt(999999);
            boolean result = EmailUtils.sendModel(email, code);
            if (result) {
                jedisUtil.addStr(email, code + "", TimeUnit.MINUTES, 5);
            }
            jedisUtil.addStr(ip, value + "", TimeUnit.MINUTES, 3);
            return ResultUtil.setOK("验证码发送", null);
        }

        return ResultUtil.setERROR("验证");
    }


    @Override
    public Result codeLogin(String email, String code, String ip) {
        String oldCode = null;
        if (email != null) {
            oldCode = jedisUtil.getStr(email);
        }

        if (oldCode == null) {
            return ResultUtil.setOtherERROR("验证码过期");
        } else {
            if (Objects.equals(oldCode, code)) {
                int i = 1;
                if (userMapper.selectByEmail(email) == null) {
                    TUser user = new TUser();
                    user.setEmail(email);
                    user.setPassword(EncrypUtil.encAesStr(Constant.REGISTERKEY, code));
                    user.setUsername(UUID.randomUUID().toString().replace("-", "").substring(0, 8));
                    i = userMapper.insert(user);
                    logsMapper.insertSelective(new TLogs(user.getId(), ip, "验证码验证"));
                    String token = TokenUtil.createToken(JSON.toJSONString(userMapper.selectById(user.getId())), Constant.CODETOKENNUMBER);
                    jedisUtil.addHash(Constant.CODETOKENKEY, "token" + token, token);
                    return ConvertUtil.convert(i, "认证", user, token);

                } else {
                    TUser user1 = userMapper.selectByEmail(email);
                    logsMapper.insertSelective(new TLogs(user1.getId(), ip, "验证码验证"));
                    String token = TokenUtil.createToken(JSON.toJSONString(userMapper.selectById(user1.getId())), Constant.CODETOKENNUMBER);
                    jedisUtil.addHash(Constant.CODETOKENKEY, "token" + token, token);
                    return ConvertUtil.convert(i, "认证", user1, token);
                }
            } else {
                return ResultUtil.setOtherERROR("验证码不一致");
            }
        }
    }

    @Override
    public Result userLogin(TUser user, String ip) {

        TUser user1 = userMapper.selectByName(user);
        String password = EncrypUtil.decAesStr(Constant.REGISTERKEY, user1.getPassword());
        if (Objects.equals(password, user.getPassword())) {

            String token = TokenUtil.createToken(JSON.toJSONString(user1), user1.getId());
            jedisUtil.addHash(Constant.TOKENKEY, token, token);
            logsMapper.insertSelective(new TLogs(user1.getId(), ip, "登录成功"));
            return ResultUtil.setOK("登录", token, user1);
        }

        return ResultUtil.setERROR("登录");
    }

    @Override
    public Result emailLogin(TUser user, String ip) {
        TUser user1 = userMapper.selectEmail(user);
        String password = EncrypUtil.decAesStr(Constant.REGISTERKEY, user1.getPassword());
        if (Objects.equals(password, user.getPassword())) {

            String token = TokenUtil.createToken(JSON.toJSONString(user1), user1.getId());
            jedisUtil.addHash(Constant.TOKENKEY, token, token);
            logsMapper.insertSelective(new TLogs(user1.getId(), ip, "登录成功"));
            return ResultUtil.setOK("登录", token, user1);
        }

        return ResultUtil.setERROR("登录");
    }

    @Override
    public Result loginOut(String token) {
        jedisUtil.delHash(Constant.TOKENKEY, token);
        jedisUtil.delHash(Constant.CODETOKENKEY, "token" + token);

        return ResultUtil.setOK("注销", null);
    }

    @Override
    public Result findPassword(TUser user) {
        if (user != null && user.getPassword() != null) {
            String password = EncrypUtil.encAesStr(Constant.REGISTERKEY, user.getPassword());
            user.setPassword(password);
        }
        return ConvertUtil.convert(userMapper.updatePassword(user), "修改密码");
    }

    @Override
    public Result checkRepeat(String email) {
        TUser user=userMapper.selectByEmail(email);
        if(user==null){
            return ResultUtil.setOK("OK",null);
        }else {
            return ResultUtil.setOtherERROR("邮箱已经存在");
        }
    }

}
