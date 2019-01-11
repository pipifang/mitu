package com.qfedu.mitu.controller;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.service.TSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcg
 * @since 2019-01-06
 */
@RestController
@RequestMapping("/api/v1")
public class TSignController {
    @Autowired
    private TSignService tSignService;

    /**
     * 根据用户ID判断用户当天的签到状态
     * @param uid
     * @return
     */
    @GetMapping("/getjudgesame")
    public Result judgesame(Integer uid){
        return tSignService.judgesame(uid);
    }

    /**
     *根据用户ID进行签到操作
     * @param uid
     * @return
     */
    @PostMapping("/addsign")
    public Result addsign (Integer uid)  {
        return tSignService.addsign(uid);
    }

    /**
     * 连续签到领取奖励积分7天为20，21天为30,30天为50
     * 超过时间奖励作废
     * @param uid
     * @return
     */
    @PutMapping("/updatesign")
    public Result updatesign (Integer uid){
        return tSignService.updatesign(uid);
    }
}
