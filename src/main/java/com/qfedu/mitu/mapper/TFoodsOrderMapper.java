package com.qfedu.mitu.mapper;

import com.qfedu.mitu.domain.FoodsAll;
import com.qfedu.mitu.domain.TFoodsOrder;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

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

    List<FoodsAll> slelctByUid(@Param("uid") Integer uid,@Param("foodslevel") Integer foodslevel);

    void insertOrder(TFoodsOrder tFoodsOrder);

    List<FoodsAll> findAll(Integer uid);

    void updateById(Integer id);

    void updateId(Integer id);

}