package com.qfedu.mitu.controller;


import com.alibaba.fastjson.JSON;
import com.qfedu.mitu.comment.token.Token;
import com.qfedu.mitu.comment.utils.OSSUtil;
import com.qfedu.mitu.comment.utils.TokenUtil;
import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.domain.TUser;
import com.qfedu.mitu.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcg
 * @since 2019-01-07
 */
@RestController
@RequestMapping("/api/v1")
public class TUserController {

    @Autowired
    private TUserService service;

    @Autowired
    OSSUtil ossUtil;
    /**
     * 上传头像，需要用户id
     *
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/head")
    public Result uploadHeadPhoto(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename() + System.currentTimeMillis();
        System.out.println("2222222222"+filename);
        String photo = ossUtil.fileUp(filename, file.getBytes());
        System.out.println("!!!!!!!!!!!!!!!!"+photo);
        String token = request.getHeader("token");
        Token parseToken = TokenUtil.parseToken(token);
        TUser user = JSON.parseObject(parseToken.getContent(), TUser.class);
        user.setPhoto(photo);
        return service.uploadHeadPhoto(user);
    }

    /**
     * 根据用户id修改信息
     *
     * @param user
     * @return
     */
    @PostMapping("/info")
    public Result updateUserInfo(TUser user, HttpServletRequest request) {
        String token = request.getHeader("token");
        Token parseToken = TokenUtil.parseToken(token);
        TUser user1 = JSON.parseObject(parseToken.getContent(), TUser.class);
        user.setId(user1.getId());
        return service.updateUserInfo(user);
    }

    /**
     * 上传用户背景图片，需要用户id
     *
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("/background")
    public Result uploadBackGround(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        String filename = file.getOriginalFilename() + System.currentTimeMillis();
        String background = ossUtil.fileUp(filename,file.getBytes());
        String token = request.getHeader("token");
        Token parseToken = TokenUtil.parseToken(token);
        TUser user = JSON.parseObject(parseToken.getContent(), TUser.class);
        user.setBackground(background);
        return service.uploadBackGround(user);
    }

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    @PostMapping("/changepassword")
    public Result updatePass(TUser user) {
        return service.updatePass(user);
    }

}
