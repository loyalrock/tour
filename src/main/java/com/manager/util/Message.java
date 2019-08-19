package com.manager.util;

public enum Message {

    SUCCESS("0000", "操作成功"),
    NOT_USER_FOUND("9001", "找不到用户");

    private String code;

    private String message;

    private Message(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private Message(String message) {
        this.code = "500";
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
