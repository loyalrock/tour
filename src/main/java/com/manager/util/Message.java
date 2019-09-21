package com.manager.util;

public enum Message {

    /**
     * 系统
     */
    SUCCESS("1000", "操作成功"),
    NOT_USER_FOUND("9001", "找不到用户"),
    DISABLE_USER("9002", "用户被禁用"),
    NEED_LOGIN("9003", "未登录"),
    PASSWORD_ERROR("9004", "密码错误"),
    NO_PERMISSIONS("9005", "没有权限，请联系全域管理员"),
    EXIST_USER("9006", "用户已存在"),
    LOGIN_SUCCESS("1000", "登陆成功"),
    CODE_UN_UNIQUE("9007", "编号不唯一"),
    FILE_IS_EMPTY("9008", "文件大小为0"),
    FILE_SAVE_FAILED("9009", "文件保存失败"),
    UN_BIND_PROJECT("9010", "请给当前用户分配项目"),
    PASSWORD_LENGTH_SHORT("9011", "密码长度不能小于6"),
    LOGIN_TYPE_ERROR("9012", "请重新选择登录前后台"),
    LOST_PARAM("9013", "缺少必要参数"),


    // 基础
    INSERT_SUCCESS("1000", "新增成功"),
    INSERT_FAILED("1001", "新增失败"),
    UPDATE_SUCCESS("1000", "修改成功"),
    UPDATE_FAILED("1003", "修改失败"),
    DELETE_SUCCESS("1000", "删除成功"),
    DELETE_FAILED("1005", "删除失败"),
    SELECT_SUCCESS("1000", "查询成功"),
    SELECT_FAILED("1007", "查询失败"),



    CONTENT_IMPORT_ERROR("2002", "内容维护导入信息有误"),
    PROJECT_IS_DISABLE("2003", "内容维护导入信息有误"),
    SUPER_CONTENT_DEACTI_ERROR("2004", "内容维护停用时间不能等于或早于今天"),
    SUPER_CONTENT_TIME_ERROR("2005", "内容维护启用时间不能等于或晚于停用时间"),
    SCORE_OVER_MAX("2006", "自评分数不能超过内容维护最大分值"),


    PROJECT_NAME_J_UNIQUE("3001", "项目简称不唯一")
    ;

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

    public static String getMessage(String code) {
        for (Message c : Message.values()) {
            if (c.getCode().equals(code)) {
                return c.message;
            }
        }
        return null;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

}
