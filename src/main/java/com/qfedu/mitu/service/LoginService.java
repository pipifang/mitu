package com.qfedu.mitu.service;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.domain.TUser;

public interface LoginService {

    /**
     * /**
     * 用户输入邮箱，发送验证码
     * @param email 用户邮箱
     * @param ip 用户ip
     * @return
     */
    Result sendCode(String email,String ip);

    /**
     * /**
     * 用户输入手机号，发送验证码
     * @param tel 用户邮箱
     *
     * @return
     */
    Result sendMesage(String tel,String ip) throws Exception;

    /**
     * 用户输入邮箱验证码验证登录
     *
     * @param code 验证码
     * @return
     */
    Result codeLogin(String email, String code,String ip);

    /**
     * 用户输入手机验证码验证登录
     *
     * @param code 验证码
     * @return
     */
    Result telLogin(String email, String code,String ip);

    /**
     * 用户名密码登录，可使用邮箱或者用户名登录
     * @param user
     * @return
     */
    Result userLogin(TUser user, String ip);

    /**
     * 邮箱密码登录
     * @param user
     * @return
     */
    Result emailLogin(TUser user, String ip);

    /**
     *用户退出
     * @param token
     * @return
     */
    Result loginOut(String token);

    /**
     * 找回密码
     * @param user
     * @return
     */
    Result findPassword(TUser user);

    /**
     * 检查邮箱是否已经被注册
     * @param email
     * @return
     */
    Result checkRepeat(String email);
}
