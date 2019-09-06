package com.manager.entry.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.beans.DefaultProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 系统用户
 * @auth zhongyan
 */
public class User {

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

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String deleteFlag;

    public User(String ss01Id, String userId, String userName, String password, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        this.ss01Id = ss01Id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}