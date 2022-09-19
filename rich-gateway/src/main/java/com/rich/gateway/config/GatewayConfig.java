package com.rich.gateway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rich.gateway.exception.GlobalExceptionHandler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xepxe
 * @date 2022/9/13 18:00
 * @desc
 */
@Configuration(proxyBeanMethods = false)
public class GatewayConfig {

    @Bean
    public GlobalExceptionHandler globalExceptionHandler(ObjectMapper objectMapper) {
        return new GlobalExceptionHandler(objectMapper);
    }
}
