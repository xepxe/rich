package com.rich.common.core.exception;

import lombok.AllArgsConstructor;

/**
 * @author xepxe
 * @date 2022/9/1 14:34
 * @desc
 */
@AllArgsConstructor
public enum ResultCode implements IResult {
    SUCCESS("200", "请求成功"),
    FAIL("500", "请求失败");;
    private final String code;
    private final String msg;


    @Override
    public String code() {
        return code;
    }

    @Override
    public String msg() {
        return msg;
    }
}
