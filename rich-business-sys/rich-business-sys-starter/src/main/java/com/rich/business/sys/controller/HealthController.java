package com.rich.business.sys.controller;

import com.rich.business.sys.api.constant.SysConstant;
import com.rich.common.core.annotation.SysLog;
import com.rich.common.core.model.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xepxe
 * @date 2022/9/1 13:22
 * @desc
 */
@Api(tags = "health")
@RestController
@RequestMapping(SysConstant.API + "/health")
@AllArgsConstructor
public class HealthController {
    @SysLog
    @ApiOperation("ping")
    @GetMapping
    public R<Void> ping() {
        return R.ok();
    }

}
