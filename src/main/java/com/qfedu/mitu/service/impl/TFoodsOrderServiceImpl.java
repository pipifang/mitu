package com.qfedu.mitu.service.impl;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.comment.vo.ResultUtil;
import com.qfedu.mitu.domain.FoodsAll;
import com.qfedu.mitu.domain.TCard;
import com.qfedu.mitu.domain.TFoodsOrder;
import com.qfedu.mitu.mapper.TCardMapper;
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

    @Autowired
    private TCardMapper tCardDao;

    @Override
    public Result selectTFoodsOrder(Integer uid,Integer foodslevel) {
        if(uid != null){
            List<FoodsAll> list = tFoodsOrderDao.slelctByUid(uid,foodslevel);
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
            TCard tCard = tCardDao.selectByUid(uid);
            int status = tCard.getStatus();
            int dicount = tCard.getDiscount();
            SimpleDateFormat df = new SimpleDateFormat("mmhhssyyyyMMdd");//设置日期格式
            String foodsOrderno = df.format(new Date());
            TFoodsOrder tFoodsOrder= new TFoodsOrder();
            if (status == 1){
                Double totalPrice = foodsPrice*personcount*dicount/10;
                System.out.println(totalPrice);
                tFoodsOrder.setFid(fid);
                tFoodsOrder.setUid(uid);
                tFoodsOrder.setTotalPrice(totalPrice);
                tFoodsOrder.setFoodsOrderno(foodsOrderno);
                tFoodsOrder.setPersoncount(personcount);
                tFoodsOrderDao.insertOrder(tFoodsOrder);
                return ResultUtil.setOK("添加",null);
            }else {
               Double totalPrice = foodsPrice*personcount;
               tFoodsOrder.setFid(fid);
               tFoodsOrder.setUid(uid);
               tFoodsOrder.setTotalPrice(totalPrice);
               tFoodsOrder.setFoodsOrderno(foodsOrderno);
               tFoodsOrder.setPersoncount(personcount);
               tFoodsOrderDao.insertOrder(tFoodsOrder);
               return ResultUtil.setOK("添加",null);
           }
        }
        return ResultUtil.setERROR("添加");
    }

    @Override
    public Result updateById(Integer id) {
        if (id != null){
            tFoodsOrderDao.updateById(id);
            return ResultUtil.setOK("支付",null);
        }
        return ResultUtil.setERROR("支付");
    }

    @Override
    public Result updateId(Integer id) {
        if (id != null){
            tFoodsOrderDao.updateId(id);
            return ResultUtil.setOK("删除",null);
        }
        return ResultUtil.setERROR("删除");
    }

}
