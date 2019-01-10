package com.qfedu.mitu.service;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.domain.TFoodsOrder;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcg
 * @since 2019-01-06
 */
public interface TFoodsOrderService extends IService<TFoodsOrder> {

    Result selectTFoodsOrder(Integer uid);
}
