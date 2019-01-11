package com.qfedu.mitu.service.impl;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.comment.vo.ResultUtil;
import com.qfedu.mitu.domain.TTrip;
import com.qfedu.mitu.mapper.TTripMapper;
import com.qfedu.mitu.service.TTripService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class TTripServiceImpl extends ServiceImpl<TTripMapper, TTrip> implements TTripService {
    @Autowired
    private TTripMapper tripMapper;


    @Override //根据ID查询t_trip对象
    public Result listTripById(Integer id) {

        try {
            TTrip trip = tripMapper.listTripById(id);
            return  ResultUtil.setOK("查询成功", trip);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.setERROR("查询失败");
        }

    }

    @Override
    public Result listAllTrip() {
        try {
            List<TTrip> list = tripMapper.listAllTrip();
            return  ResultUtil.setOK("查询成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.setERROR("查询失败");
        }
    }

    @Override
    public Result listTripByLocation(String tripLocation) {
        try {
            List<TTrip> list = tripMapper.listTripByLocation(tripLocation);
            return  ResultUtil.setOK("查询成功", list);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResultUtil.setERROR("查询失败");
        }
    }
}
