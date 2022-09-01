package com.rich.common.core.annotation;

import com.rich.common.core.constant.OperationEnum;

import java.lang.annotation.*;

/**
 * @author xepxe
 * @date 2022/9/1 11:30
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";

    OperationEnum operation() default OperationEnum.QUERY;

}
