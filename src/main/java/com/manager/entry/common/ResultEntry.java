package com.manager.entry.common;

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

    public ResultEntry () {};

    public void setBody(Object body) {
        this.body = body;
    }

    public ResultEntry(Object body) {
        this.code = "0000";
        this.message = "success";
        this.body = body;
    }

    public ResultEntry(String code, String message, Object body ) {
        this.code = code;
        this.message = message;
        this.body = body;
    }
}
