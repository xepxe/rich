package com.rich.business.sys.controller;

import com.rich.business.sys.api.constant.SysConstant;
import com.rich.business.sys.constant.SysCacheEnum;
import com.rich.business.sys.model.req.UserReq;
import com.rich.business.sys.model.req.UserSaveReq;
import com.rich.business.sys.model.req.UserUpdateReq;
import com.rich.business.sys.model.vo.UserVO;
import com.rich.business.sys.service.UserService;
import com.rich.common.core.annotation.SysLog;
import com.rich.common.core.constant.OperationEnum;
import com.rich.common.core.model.R;
import com.rich.common.db.model.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @SysLog(value = "分页查询用户", operation = OperationEnum.QUERY)
    @GetMapping
    @Cacheable(value = SysCacheEnum.USERS)

    public R<PageVO<UserVO>> queryUserPage(UserReq req) {
        return R.ok(userService.queryUserPage(req));
    }

    @ApiOperation(value = "保存用户")
    @PostMapping
    public R<Boolean> saveUser(@RequestBody UserSaveReq req) {
        return R.ok(userService.saveUser(req));
    }

    @ApiOperation(value = "更新用户")
    @PutMapping
    public R<Boolean> updateUser(@RequestBody UserUpdateReq req) {
        return R.ok(userService.updateUser(req));
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping
    public R<Boolean> delUser(@RequestParam(value = "ids") List<Integer> ids) {
        return R.ok(userService.delUser(ids));
    }

}
