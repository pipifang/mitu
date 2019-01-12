package com.qfedu.mitu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.mitu.comment.utils.ConvertUtil;
import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.comment.vo.ResultUtil;
import com.qfedu.mitu.domain.TCollections;
import com.qfedu.mitu.mapper.TCollectionsMapper;
import com.qfedu.mitu.service.TCollectionsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcg
 * @since 2019-01-11
 */
@Service
public class TCollectionsServiceImpl extends ServiceImpl<TCollectionsMapper, TCollections> implements TCollectionsService {

    @Autowired
    private TCollectionsMapper mapper;
    @Override
    public Result collect(int tid, int uid) {
        TCollections collections = new TCollections();
        if (mapper.selectExist(tid, uid) == null) {
            collections.setTid(tid);
            collections.setUid(uid);
            return ConvertUtil.convert("收藏", mapper.insert(collections));
        } else {
            return ResultUtil.setOtherERROR("已经收藏过了。。");
        }
    }

    @Override
    public Result collectFood(int tid, int uid) {
        TCollections collections = new TCollections();
        if (mapper.selectExist(tid, uid) == null) {
            collections.setTid(tid);
            collections.setUid(uid);
            return ConvertUtil.convert("收藏", mapper.insertFood(collections));
        } else {
            return ResultUtil.setOtherERROR("已经收藏过了。。");
        }
    }

    @Override
    public Result collectTrip(int tid, int uid) {
        TCollections collections = new TCollections();
        if (mapper.selectExist(tid, uid) == null) {
            collections.setTid(tid);
            collections.setUid(uid);
            return ConvertUtil.convert("收藏", mapper.insertTrip(collections));
        } else {
            return ResultUtil.setOtherERROR("已经收藏过了。。");
        }
    }

    @Override
    public Result showAllCollections(int uid, int page) {
        PageHelper.startPage(page, 10);
        List<Map<String, Object>> list = mapper.selectCollect(uid);
        PageInfo<Map<String, Object>> listInfo = new PageInfo<>(list);


        PageHelper.startPage(page, 10);
        List<Map<String, Object>> food = mapper.selectCollectFood(uid);
        PageInfo<Map<String, Object>> foodlInfo = new PageInfo<>(food);


        PageHelper.startPage(page, 10);
        List<Map<String, Object>> trip = mapper.selectCollectTrip(uid);
        PageInfo<Map<String, Object>> tripInfo = new PageInfo<>(trip);


        HashMap<String, Object> allCollections = new HashMap<>(16);
        allCollections.put("list", listInfo.getList());
        allCollections.put("food", foodlInfo.getList());
        allCollections.put("trip", tripInfo.getList());

        return ConvertUtil.convert("查询所有收藏", allCollections);
    }

    @Override
    public Result deleteCollection(int cid, int type) {
        if (type == 1) {
            return ConvertUtil.convert(mapper.deleteByPrimaryKey(cid), "移除收藏");
        } else if (type == 2) {
            return ConvertUtil.convert(mapper.deleteFood(cid), "移除收藏");
        } else if (type == 3) {
            return ConvertUtil.convert(mapper.deleteTrip(cid), "移除收藏");
        } else {
            return ResultUtil.setOtherERROR("删除收藏失败");
        }
    }
}
