package com.qfedu.mitu.mapper;

import com.qfedu.mitu.domain.FoodsAll;
import com.qfedu.mitu.domain.TFoodsOrder;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zcg
 * @since 2019-01-10
 */
public interface TFoodsOrderMapper extends BaseMapper<TFoodsOrder> {

    List<FoodsAll> slelctByUid(Integer uid);

    List<FoodsAll> findByUid(Integer uid);

    List<FoodsAll> findUid(Integer uid);

    List<FoodsAll> findAll(Integer uid);

    void insertOrder(TFoodsOrder tFoodsOrder);
}