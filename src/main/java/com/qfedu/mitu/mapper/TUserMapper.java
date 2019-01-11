package com.qfedu.mitu.mapper;

import com.qfedu.mitu.domain.TUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zcg
 * @since 2019-01-06
 */
public interface TUserMapper extends BaseMapper<TUser> {

    TUser selectByName(TUser user);

    int updatePassword(TUser user);

    int uploadHeadPhoto(TUser user);

    TUser selectByEmail(String email);

    int uploadBackGround(TUser user);

    TUser selectEmail(TUser user);

}