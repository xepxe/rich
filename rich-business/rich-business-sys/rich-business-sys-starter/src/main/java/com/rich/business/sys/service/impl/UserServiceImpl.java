package com.rich.business.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rich.business.sys.entity.UserEntity;
import com.rich.business.sys.mapper.UserMapper;
import com.rich.business.sys.model.query.UserQuery;
import com.rich.business.sys.model.vo.UserVO;
import com.rich.business.sys.service.UserService;
import com.rich.common.db.model.PageResult;
import org.springframework.stereotype.Service;

/**
 * @author xepxe
 * @date 2022/9/9 16:08
 * @desc
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public PageResult<UserVO> queryUserPage(UserQuery query) {
        Page<UserVO> userPage = new Page<>(query.getPageNum(), query.getPageSize());
        userPage = getBaseMapper().queryUserPage(userPage, query);
        return PageResult.to(userPage);
    }
}
