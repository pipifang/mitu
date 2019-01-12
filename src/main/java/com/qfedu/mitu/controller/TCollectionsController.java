package com.qfedu.mitu.controller;

import com.alibaba.fastjson.JSON;
import com.qfedu.mitu.comment.token.Token;
import com.qfedu.mitu.comment.utils.TokenUtil;
import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.domain.TCollections;
import com.qfedu.mitu.domain.TUser;
import com.qfedu.mitu.service.TCollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcg
 * @since 2019-01-11
 */
@RestController
@RequestMapping("/api/v1")
public class TCollectionsController {

    @Autowired
    private TCollectionsService service;

    //新增
    @PostMapping("/collection/food")
    public Result addCollectionHotel(int id, HttpServletRequest request) {
        String token = request.getHeader("token");
        Token parseToken = TokenUtil.parseToken(token);
        TUser user = JSON.parseObject(parseToken.getContent(), TUser.class);
        return service.collectFood(id, user.getId());
    }

    @PostMapping("/collection/trip")
    public Result addCollectionStrategy(int id, HttpServletRequest request) {
        String token = request.getHeader("token");
        Token parseToken = TokenUtil.parseToken(token);
        TUser user = JSON.parseObject(parseToken.getContent(), TUser.class);
        return service.collectTrip(id, user.getId());
    }

    @GetMapping("/collections")
    public Result addCollection(HttpServletRequest request, int page) {
        String token = request.getHeader("token");
        Token parseToken = TokenUtil.parseToken(token);
        TUser user = JSON.parseObject(parseToken.getContent(), TUser.class);
        return service.showAllCollections(user.getId(), page);
    }

    @PostMapping("/remove")
    public Result addCollection(int cid, int type) {

        return service.deleteCollection(cid, type);
    }
}
