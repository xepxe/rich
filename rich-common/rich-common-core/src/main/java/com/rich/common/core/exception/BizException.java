package com.rich.common.core.exception;

import lombok.Getter;

/**
 * @author xepxe
 * @date 2022/9/1 14:30
 * @desc
 */
@Getter
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 4571263678168285907L;
    private final IResult result;

    public BizException(IError error) {
        super(error.msg());
        this.error = error;
    }

}
