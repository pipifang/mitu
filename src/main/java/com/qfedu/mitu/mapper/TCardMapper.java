package com.qfedu.mitu.mapper;

import com.qfedu.mitu.domain.TCard;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zcg
 * @since 2019-01-06
 */
public interface TCardMapper extends BaseMapper<TCard> {

    TCard selectByUid(Integer uid);
}