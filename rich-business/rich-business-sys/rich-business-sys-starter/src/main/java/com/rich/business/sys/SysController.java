package com.rich.business.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xepxe
 * @date 2022/9/1 13:21
 * @desc
 */
@MapperScan({"com.rich.business.sys.mapper"})
@SpringBootApplication
@EnableDiscoveryClient
public class SysController {
    public static void main(String[] args) {
        SpringApplication.run(SysController.class, args);
    }
}
