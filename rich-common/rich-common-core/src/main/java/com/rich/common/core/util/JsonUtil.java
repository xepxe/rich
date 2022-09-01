package com.rich.common.core.util;

import com.alibaba.fastjson.JSON;

/**
 * @author xepxe
 * @date 2022/9/1 12:31
 * @desc
 */
public class JsonUtil {

    public static String to(Object data) {
        return JSON.toJSONString(data);
    }

}
