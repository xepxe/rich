package com.rich.common.core.model;

import com.rich.common.core.constant.OperationEnum;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * @author xepxe
 * @date 2022/9/1 12:19
 * @desc
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SysLogDTO {
    /**
     * 日志id
     */
    Long id;

    /**
     * 操作用户id
     */
    Long userId;

    /**
     * 操作用户
     */
    String username;

    String name;
    /**
     * 操作
     */
    OperationEnum operation;

    /**
     * 方法
     */
    String method;

    /**
     * 参数
     */
    Object params;

    Object result;
    String exception;

    /**
     * 耗时
     */
    Long cost;

    /**
     * 操作ip地址
     */
    String ip;

    /**
     * 创建时间
     */
    Date createTime;

}
