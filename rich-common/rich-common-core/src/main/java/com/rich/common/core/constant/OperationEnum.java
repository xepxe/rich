package com.rich.common.core.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author xepxe
 * @date 2022/9/1 11:33
 */
@Getter
@AllArgsConstructor
public enum OperationEnum {
    ADD(1, "新增"),
    DEL(2, "删除"),
    UPDATE(3, "修改"),
    QUERY(4, "查找"),
    ;
    private final Integer code;
    private final String desc;
}
