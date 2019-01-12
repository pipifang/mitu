package com.qfedu.mitu.mapper;

import com.qfedu.mitu.domain.TCollections;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zcg
 * @since 2019-01-11
 */
public interface TCollectionsMapper extends BaseMapper<TCollections> {

    int deleteByPrimaryKey(Integer id);

    int deleteFood(Integer id);

    int deleteTrip(Integer id);

    int insertTrip(TCollections record);

    int insertFood(TCollections record);

    TCollections selectExist(@Param("tid") Integer tid, @Param("uid")int uid);

    List<Map<String, Object>> selectCollect(int uid);

    List<Map<String, Object>> selectCollectFood(int uid);

    List<Map<String, Object>> selectCollectTrip(int uid);

}