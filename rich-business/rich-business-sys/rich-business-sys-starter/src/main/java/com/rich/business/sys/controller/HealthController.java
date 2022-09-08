package com.rich.business.sys.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.rich.business.sys.api.constant.SysConstant;
import com.rich.common.core.annotation.SysLog;
import com.rich.common.core.model.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Executor;

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
    private final DataSource dataSource;

    @PostConstruct
    public void before() throws NacosException, InterruptedException, SQLException {
        dataSource.getConnection().prepareStatement("select 1").executeQuery();
        System.out.println(dataSource);
        String serverAddr = "192.168.126.141:8848";
        String dataId = "rich-business-base";
        String group = "xepxe";
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        properties.put(PropertyKeyConst.NAMESPACE, "e955ad8d-2a87-484d-aba9-c1ff0e8811fe");
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("recieve:" + configInfo);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });
    }

    @SysLog
    @ApiOperation("ping")
    @GetMapping
    public R<Void> ping() {
        return R.ok();
    }

}
