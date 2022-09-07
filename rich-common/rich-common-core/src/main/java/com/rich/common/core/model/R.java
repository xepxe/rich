package com.rich.common.core.model;

import com.rich.common.core.exception.IResult;
import com.rich.common.core.exception.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

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
        return ok(ResultCode.SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return R.ok(ResultCode.SUCCESS, data);
    }

    public static <T> R<T> ok(IResult e, T data) {
        R<T> r = new R<>();
        r.setCode(e.code());
        r.setMsg(e.msg());
        r.setData(data);
        return r;
    }

    public static <T> R<T> fail() {
        return fail(ResultCode.FAIL, null);
    }

    public static <T> R<T> fail(T data) {
        return R.fail(ResultCode.FAIL, data);
    }

    public static <T> R<T> fail(IResult e) {
        return R.fail(e, null);
    }

    public static <T> R<T> fail(IResult e, T data) {
        R<T> r = new R<>();
        r.setCode(e.code());
        r.setMsg(e.msg());
        r.setData(data);
        return r;
    }


}
