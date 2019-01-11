package com.qfedu.mitu.mapper;

import com.qfedu.mitu.domain.TTrip;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zcg
 * @since 2019-01-06
 */
public interface TTripMapper extends BaseMapper<TTrip> {
    public TTrip listTripById(Integer id);
    public List<TTrip> listAllTrip();
    public List<TTrip> listTripByLocation(String tripLocation);
}
