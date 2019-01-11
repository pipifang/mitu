package com.qfedu.mitu.service.impl;

import com.qfedu.mitu.comment.constant.Constant;
import com.qfedu.mitu.comment.utils.ConvertUtil;
import com.qfedu.mitu.comment.utils.EncrypUtil;
import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.comment.vo.ResultUtil;
import com.qfedu.mitu.domain.TUser;
import com.qfedu.mitu.mapper.TUserMapper;
import com.qfedu.mitu.service.TUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcg
 * @since 2019-01-06
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Autowired
    private TUserMapper mapper;

    @Override
    public Result uploadHeadPhoto(TUser user) {
        return ConvertUtil.convert(mapper.uploadHeadPhoto(user), "修改头像");
    }

    @Override
    public Result updateUserInfo(TUser user) {
        if (user != null && user.getPassword() != null) {
            EncrypUtil.encAesStr(Constant.REGISTERKEY, user.getPassword());
        }
        return ConvertUtil.convert(mapper.updateById(user), "修改信息");
    }

    @Override
    public Result uploadBackGround(TUser user) {
        return ConvertUtil.convert(mapper.uploadBackGround(user), "修改背景");
    }

    @Override
    public Result updatePass(TUser user) {
        if (user != null && user.getPassword() != null) {
            String password = EncrypUtil.encAesStr(Constant.REGISTERKEY, user.getPassword());
            user.setPassword(password);
        }
        return ConvertUtil.convert(mapper.updateById(user), "修改密码");
    }

}
