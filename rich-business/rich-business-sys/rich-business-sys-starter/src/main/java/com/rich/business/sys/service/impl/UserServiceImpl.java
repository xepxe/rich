package com.rich.business.sys.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rich.business.sys.entity.UserEntity;
import com.rich.business.sys.mapper.UserMapper;
import com.rich.business.sys.model.req.UserReq;
import com.rich.business.sys.model.req.UserSaveReq;
import com.rich.business.sys.model.req.UserUpdateReq;
import com.rich.business.sys.model.vo.UserVO;
import com.rich.business.sys.service.UserService;
import com.rich.common.db.model.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xepxe
 * @date 2022/9/9 16:08
 * @desc
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Override
    public PageVO<UserVO> queryUserPage(UserReq req) {
        Page<UserVO> userPage = new Page<>(req.getPageNum(), req.getPageSize());
        userPage = getBaseMapper().queryUserPage(userPage, req);
        return PageVO.to(userPage);
    }

    @Override
    public Boolean saveUser(UserSaveReq req) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(req, userEntity);
        userEntity.setStatus(Boolean.FALSE);
        return save(userEntity);
    }

    @Override
    public Boolean updateUser(UserUpdateReq req) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(req, userEntity);
        return updateById(userEntity);
    }

    @Override
    public Boolean delUser(List<Integer> ids) {
        return removeBatchByIds(ids);
    }
}
