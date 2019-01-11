package com.qfedu.mitu.controller;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.comment.vo.ResultUtil;
import com.qfedu.mitu.domain.TUser;
import com.qfedu.mitu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author : zcg
 * @Data ：Create in 10:032019/1/7
 */
@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    private LoginService service;

    /**
     * 用户发送验证码或者找回密码
     *
     * @param email
     * @param request
     * @return
     */
    @PostMapping("/code")
    public Result sendCode(String email, HttpServletRequest request) {

        return service.sendCode(email, request.getRemoteAddr());
    }

    /**
     * 验证码登录或者验证验证码是否正确（找回密码）
     *
     * @param email
     * @param code
     * @param request
     * @return
     */
    @PostMapping("/codeLogin")
    public Result codeLogin(String email, String code, HttpServletRequest request) {

        return service.codeLogin(email, code, request.getRemoteAddr());
    }

    @GetMapping("/login")
    public Result userLogin(TUser user, HttpServletRequest request) {
        return service.userLogin(user, request.getRemoteAddr());
    }

    @GetMapping("/emaillogin")
    public Result emailLogin(TUser user, HttpServletRequest request) {
        return service.emailLogin(user, request.getRemoteAddr());
    }

    @PostMapping("/loginout")
    public Result loginOut(HttpServletRequest request) {
        String token = request.getHeader("token");
        return token != null ? service.loginOut(token) : ResultUtil.setOtherERROR("令牌无效");
    }

    /**
     * 通过验找回修改密码和设置密码
     *
     * @param user
     * @return
     */
    @PostMapping("/password")
    public Result updatePass(TUser user) {
        return service.findPassword(user);
    }

    /**
     * 检查用户名是否存在
     *
     * @param email
     * @return
     */
    @PostMapping("/checkemail")
    public Result checkEmail(String email) {
        return service.checkRepeat(email);
    }

}
