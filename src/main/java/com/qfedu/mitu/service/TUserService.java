package com.qfedu.mitu.service;

import com.qfedu.mitu.comment.vo.Result;
import com.qfedu.mitu.domain.TUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcg
 * @since 2019-01-06
 */

public interface TUserService extends IService<TUser> {

    /**
     * 上传头像
     * @param user
     * @return
     */
    Result uploadHeadPhoto(TUser user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Result updateUserInfo(TUser user);

    /**
     * 上传背景图片
     * @param user
     * @return
     */
    Result uploadBackGround(TUser user);

    /**
     * 修改用户密码
     * @param user
     * @return
     */
    Result updatePass(TUser user);

}
