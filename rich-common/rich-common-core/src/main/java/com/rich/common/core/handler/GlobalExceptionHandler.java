package com.rich.common.core.handler;

import com.rich.common.core.exception.BizException;
import com.rich.common.core.exception.ResultCode;
import com.rich.common.core.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author xth
 * @date 2022/9/8
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BizException.class})
    public R<Void> bizException(BizException e) {
        log.error("bizException error:{}", e.getMessage());
        return R.fail(e.getResult());
    }

    @ExceptionHandler({Exception.class})
    public R<Void> exception(Exception e) {
        log.error("exception error:{}", e.getMessage());
        return R.fail(ResultCode.FAIL);
    }
}
