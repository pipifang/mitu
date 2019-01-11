package com.qfedu.mitu.service;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.domain.TTrip;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcg
 * @since 2019-01-06
 */
public interface TTripService extends IService<TTrip> {
    Result listTripById(Integer id);
    Result listAllTrip();
    Result listTripByLocation(String tripLocation);
}
