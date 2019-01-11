package com.qfedu.mitu.service.impl;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.domain.TFoodsOrder;
import com.qfedu.mitu.mapper.TFoodsOrderMapper;
import com.qfedu.mitu.service.TFoodsOrderService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcg
 * @since 2019-01-06
 */
@Service
public class TFoodsOrderServiceImpl extends ServiceImpl<TFoodsOrderMapper, TFoodsOrder> implements TFoodsOrderService {

    @Autowired
    private TFoodsOrderMapper tFoodsOrderDao;
    @Override
    public Result selectTFoodsOrder(Integer uid) {
        if(uid != null){
            List<FoodsAll> list = tFoodsOrderDao.slelctByUid(uid);
            return ResultUtil.setOK("查询",list);
        }
        return ResultUtil.setERROR("查询");
    }

    @Override
    public Result selectwanna(Integer uid) {
        if(uid != null){
            List<FoodsAll> list = tFoodsOrderDao.findByUid(uid);
            return ResultUtil.setOK("查询",list);
        }
        return ResultUtil.setERROR("查询");
    }

    @Override
    public Result findUid(Integer uid) {
        if(uid != null){
            List<FoodsAll> list = tFoodsOrderDao.findUid(uid);
            return ResultUtil.setOK("查询",list);
        }
        return ResultUtil.setERROR("查询");
    }

    @Override
    public Result findAll(Integer uid) {
        if(uid != null){
            List<FoodsAll> list = tFoodsOrderDao.findAll(uid);
            return ResultUtil.setOK("查询",list);
        }
        return ResultUtil.setERROR("查询");
    }

    @Override
    public Result addOrder(Integer uid, Integer fid, Double foodsPrice, Integer personcount) {
        if (uid != null){
            Double totalPrice = foodsPrice * personcount;
            SimpleDateFormat df = new SimpleDateFormat("mmhhssyyyyMMdd");//设置日期格式
            String foodsOrderno = df.format(new Date());
            System.out.println(foodsOrderno);
            TFoodsOrder tFoodsOrder= new TFoodsOrder();
            tFoodsOrder.setFid(fid);
            tFoodsOrder.setUid(uid);
            tFoodsOrder.setTotalPrice(totalPrice);
            tFoodsOrder.setFoodsOrderno(foodsOrderno);
            tFoodsOrder.setPersoncount(personcount);
            tFoodsOrderDao.insertOrder(tFoodsOrder);
            return ResultUtil.setOK("添加",null);
        }
        return ResultUtil.setERROR("添加");
    }

}
