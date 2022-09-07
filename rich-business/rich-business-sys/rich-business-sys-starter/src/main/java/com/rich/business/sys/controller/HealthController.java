package com.rich.business.sys.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rich.business.sys.entity.DemoEntity;
import com.rich.business.sys.mapper.DemoMapper;
import com.rich.common.core.constant.Constant;
import com.rich.common.core.model.R;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author xepxe
 * @date 2022/9/1 13:22
 * @desc
 */
@RestController
@RequestMapping(Constant.API + "/health")
@AllArgsConstructor
public class HealthController {

    private final DataSource dataSource;
    private final DemoMapper demoMapper;

    private final List<InnerInterceptor> innerInterceptorList;

    @PostConstruct
    public void pre() throws SQLException {
        List<InnerInterceptor> innerInterceptorList1 = innerInterceptorList;
        Page<DemoEntity> page = new Page<>(1, 1);
        page = demoMapper.selectPage(page, Wrappers.lambdaQuery());
        System.out.println(page.getRecords());

    }

    @ApiOperation("ping")
    @GetMapping
    public R<Void> ping() {
        return R.ok();
    }

}
