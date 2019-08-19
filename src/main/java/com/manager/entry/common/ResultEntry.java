package com.manager.entry.common;

import com.manager.util.Message;

/**
 * 统一返回实体
 */
public class ResultEntry {

    private String code;

    private String message;

    private Object body;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        return body;
    }

    public ResultEntry () {
        this.code = Message.SUCCESS.getCode();
        this.message = Message.SUCCESS.getMessage();
    };

    public void setBody(Object body) {
        this.body = body;
    }

    public ResultEntry(Object body) {
        this.code = Message.SUCCESS.getCode();
        this.message = Message.SUCCESS.getMessage();
        this.body = body;
    }

    public ResultEntry(String code, String message, Object body ) {
        this.code = code;
        this.message = message;
        this.body = body;
    }

    public ResultEntry(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
