package com.manager.util;

public enum Message {

    SUCCESS("0000", "操作成功"),
    NOT_USER_FOUND("9001", "找不到用户"),
    DISABLE_USER("9002", "用户被禁用"),
    NEED_LOGIN("9003", "未登录"),
    PASSWORD_ERROR("9004", "密码错误"),
    NO_PERMISSIONS("9005", "没有权限，请联系全域管理员");

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
