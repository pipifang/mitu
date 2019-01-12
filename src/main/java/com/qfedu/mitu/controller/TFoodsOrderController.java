package com.qfedu.mitu.controller;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.service.TFoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TFoodsOrderController {
   @Autowired
    private TFoodsOrderService tFoodsOrderService;

    /**
     * 查看美食订单状态 1未支付 2已支付
     * @param uid
     * @param foodslevel
     * @return
     */
    @GetMapping("/selectTFoodsOrder")
    public Result selectTFoodsOrder(Integer uid,Integer foodslevel){
        return tFoodsOrderService.selectTFoodsOrder(uid,foodslevel);
    }

    /**
     * 查看用户所有订单
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

    /**
     * 支付
     * @param id
     * @return
     */
    @PutMapping("updateById")
    public Result updateById(Integer id){
        return tFoodsOrderService.updateById(id);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @PutMapping("updateId")
    public Result updateId(Integer id){
        return tFoodsOrderService.updateId(id);
    }
}
