package com.qfedu.mitu.mapper;

import com.qfedu.mitu.domain.TLogs;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zcg
 * @since 2019-01-07
 */
public interface TLogsMapper extends BaseMapper<TLogs> {

    int insertSelective(TLogs logs);
}