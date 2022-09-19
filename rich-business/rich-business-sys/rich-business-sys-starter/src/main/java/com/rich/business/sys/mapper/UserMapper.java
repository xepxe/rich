package com.rich.business.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rich.business.sys.entity.UserEntity;
import com.rich.business.sys.model.req.UserReq;
import com.rich.business.sys.model.vo.UserVO;
import org.apache.ibatis.annotations.Param;

/**
 * @author xepxe
 * @date 2022/9/9 15:38
 * @desc
 */
public interface UserMapper extends BaseMapper<UserEntity> {
    Page<UserVO> queryUserPage(Page<UserVO> userPage, @Param("q") UserReq req);
}
