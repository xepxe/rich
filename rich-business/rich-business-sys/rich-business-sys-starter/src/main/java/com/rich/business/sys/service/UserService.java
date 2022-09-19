package com.rich.business.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rich.business.sys.entity.UserEntity;
import com.rich.business.sys.model.req.UserReq;
import com.rich.business.sys.model.req.UserSaveReq;
import com.rich.business.sys.model.req.UserUpdateReq;
import com.rich.business.sys.model.vo.UserVO;
import com.rich.common.db.model.PageVO;

import java.util.List;

/**
 * @author xepxe
 * @date 2022/9/9 16:08
 * @desc
 */
public interface UserService extends IService<UserEntity> {
    PageVO<UserVO> queryUserPage(UserReq req);

    Boolean saveUser(UserSaveReq req);

    Boolean updateUser(UserUpdateReq req);

    Boolean delUser(List<Integer> ids);
}
