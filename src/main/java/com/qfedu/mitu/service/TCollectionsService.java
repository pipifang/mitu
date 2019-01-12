package com.qfedu.mitu.service;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.domain.TCollections;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcg
 * @since 2019-01-11
 */
public interface TCollectionsService extends IService<TCollections> {
    Result collect(int tid, int uid);

    Result collectFood(int fid,int uid);

    Result collectTrip(int trid,int uid);

    Result showAllCollections(int uid,int page);

    Result deleteCollection(int cid,int type);
}
