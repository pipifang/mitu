package com.qfedu.mitu.controller;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.service.TFoodsService;
import com.qfedu.mitu.service.impl.TFoodsOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class TFoodsOrderController {
   @Autowired
    private TFoodsOrderService tFoodsOrderService;

    /**
     * 已删除美食订单
     * @param uid
     * @return
     */
    @GetMapping("/selectTFoodsOrder")
    public Result selectTFoodsOrder(Integer uid){
        return tFoodsOrderService.selectTFoodsOrder(uid);
    }

    /**
     * 查看未支付订单
     * @param uid
     * @return
     */
    @GetMapping("/selectwanna")
    public Result selectwanna(Integer uid){
        return tFoodsOrderService.selectwanna(uid);
    }

    /**
     * 查看已支付订单
     * @param uid
     * @return
     */
    @GetMapping("/findUid")
    public Result findUid(Integer uid){
        return tFoodsOrderService.findUid(uid);
    }

    /**
     * 查看所有订单
     * @param uid
     * @return
     */
    @GetMapping("/findAll")
    public Result findAll(Integer uid){
        return tFoodsOrderService.findAll(uid);
    }

    /**
     * 添加订单
     * @param uid
     * @param fid
     * @param foodsPrice
     * @param personcount
     * @return
     */
    @PostMapping("/addOrder")
    public Result addOrder(Integer uid, Integer fid, Double foodsPrice, Integer personcount){
        return tFoodsOrderService.addOrder(uid,fid,foodsPrice,personcount);
    }
}
