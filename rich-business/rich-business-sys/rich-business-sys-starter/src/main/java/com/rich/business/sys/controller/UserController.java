package com.rich.business.sys.controller;

import com.rich.business.sys.api.constant.SysConstant;
import com.rich.business.sys.model.query.UserQuery;
import com.rich.business.sys.model.vo.UserVO;
import com.rich.business.sys.service.UserService;
import com.rich.common.db.model.PageResult;
import com.rich.common.core.model.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author xepxe
 * @date 2022/9/1 15:45
 * @desc
 */
@Api(tags = "01.用户管理")
@RestController
@RequestMapping(SysConstant.API + "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @ApiOperation(value = "分页查询用户")
    @GetMapping
    public R<PageResult<UserVO>> queryUserPage(UserQuery query) {
        return R.ok(userService.queryUserPage(query));
    }

    @ApiOperation(value = "保存用户")
    @PostMapping
    public R<PageResult<Void>> saveUser() {
        return R.ok();
    }

    @ApiOperation(value = "更新用户")
    @PutMapping
    public R<PageResult<Void>> updateUser() {
        return R.ok();
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping
    public R<PageResult<Void>> delUser() {
        return R.ok();
    }



}
