package com.manager.util;

import com.manager.entry.common.ResultEntry;

/**
 * 描述
 *
 * @author nosign
 * @date 2019/08/16
 */
public class ResultUtil {

    public static ResultEntry success(Message message) {
        return new ResultEntry(message.getCode(), message.getMessage());
    }

    public static ResultEntry success(Message message, Object body) {
        return new ResultEntry(message.getCode(), message.getMessage(), body);
    }

    public static ResultEntry success() {
        return new ResultEntry();
    }

    public static ResultEntry error(Message message) {
        return new ResultEntry(message.getCode(), message.getMessage());
    }

    public static ResultEntry error(Message message, Object obj) {
        return new ResultEntry(message.getCode(), message.getMessage(), obj);
    }

    public static ResultEntry error(String m) {
        return ResultUtil.error(Message.SYSTEM_ERROR, m);
    }
}
