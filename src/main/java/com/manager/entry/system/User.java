package com.manager.entry.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manager.entry.common.CommonEntry;
import javafx.beans.DefaultProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 系统用户
 * @auth zhongyan
 */
public class User extends CommonEntry {

    /**
     * 启用
     */
    public static final String ENABLE = "1";

    /**
     * 禁用
     */
    public static final String DISABLE = "0";

    private String ss01Id;

    /**
     * 登录账号
     */
    private String userId;

    /**
     * 用户姓名
     */
    @NotBlank(message = "用户名称不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    public User(String ss01Id, String userId, String userName, String password, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.ss01Id = ss01Id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    public User() {
        super();
    }

    public String getSs01Id() {
        return ss01Id;
    }

    public void setSs01Id(String ss01Id) {
        this.ss01Id = ss01Id == null ? null : ss01Id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}
