package com.manager.util;

import com.manager.entry.common.ResultEntry;

/**
 * 描述
 *
 * @auth0r nosign
 * @date 2019/08/16
 */
public class ResultUtil {

    public static ResultEntry success(Object obj) {
        return new ResultEntry(obj);
    }

    public static ResultEntry success() {
        return new ResultEntry();
    }

    public static ResultEntry error(Message message) {
        return new ResultEntry(message.getCode(), message.getMessage());
    }
}
