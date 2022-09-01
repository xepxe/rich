package com.rich.common.knife4j.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.rich.common.knife4j.model.Knife4jProperty;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @author xepxe
 * @date 2022/9/1 13:35
 * @desc
 */
@EnableKnife4j
@EnableSwagger2WebMvc
@AutoConfiguration
@EnableConfigurationProperties(Knife4jProperty.class)
@ConditionalOnProperty(prefix = "knife4j", value = "enable", matchIfMissing = true)
@AllArgsConstructor
public class Knife4jConfig {
    private final Knife4jProperty knife4jProperty;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(new ApiInfoBuilder()
                        .description(knife4jProperty.getDescription())
                        .title(knife4jProperty.getTitle())
                        .contact(new Contact(knife4jProperty.getContactName(), knife4jProperty.getContactUrl(), knife4jProperty.getContactEmail()))
                        .version(knife4jProperty.getVersion())
                        .build())
                .groupName(knife4jProperty.getGroupName())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }
}
