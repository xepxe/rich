package com.rich.common.core.model;

import com.rich.common.core.exception.ErrorEnum;
import com.rich.common.core.exception.IError;
import lombok.*;

import java.io.Serializable;
import java.util.Map;

/**
 * @author xepxe
 * @date 2022/9/1 14:11
 * @desc
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class R<T> implements Serializable {

    private static final long serialVersionUID = 2462270289256366073L;
    private String code;
    private String msg;
    private T data;
    private Map<String, Object> addition;

    public static <T> R<T> ok() {
        return ok(ErrorEnum.SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return R.ok(ErrorEnum.SUCCESS, data);
    }

    public static <T> R<T> ok(IError e, T data) {
        R<T> r = new R<>();
        r.setCode(e.code());
        r.setMsg(e.msg());
        r.setData(data);
        return r;
    }

    public static <T> R<T> fail() {
        return fail(ErrorEnum.FAIL, null);
    }

    public static <T> R<T> fail(T data) {
        return R.fail(ErrorEnum.FAIL, data);
    }

    public static <T> R<T> fail(IError e) {
        return R.fail(e, null);
    }

    public static <T> R<T> fail(IError e, T data) {
        R<T> r = new R<>();
        r.setCode(e.code());
        r.setMsg(e.msg());
        r.setData(data);
        return r;
    }


}
