package com.rich.business.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.rich.business.sys.entity.UserEntity;
import com.rich.business.sys.model.query.UserQuery;
import com.rich.business.sys.model.vo.UserVO;
import com.rich.common.db.model.PageResult;

/**
 * @author xepxe
 * @date 2022/9/9 16:08
 * @desc
 */
public interface UserService extends IService<UserEntity> {
    PageResult<UserVO> queryUserPage(UserQuery query);
}
