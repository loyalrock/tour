package com.manager.entry.system;

import com.manager.util.InsertGroup;
import com.manager.util.UpdateGroup;

import javax.validation.constraints.NotBlank;

/**
 * 用户管理查询实体类
 * @author zhongyan
 */
public class UserManager {

    /**
     * 用户主键
     */
    @NotBlank(message = "唯一键必须", groups = {UpdateGroup.class})
    private String ss01Id;

    @NotBlank(message = "登录名未填写")
    private String userId;

    @NotBlank(message = "用户名称未填写")
    private String userName;

    private String status;

    @NotBlank(message = "角色未选择")
    private String userRoleId;

    private String userRoleName;

    @NotBlank(message = "所属单位未填写")
    private String opUnit;

    @NotBlank(message = "所属项目未选择")
    private String projectNo;

    private String projectName;

    private String projectNameJ;

    public String getSs01Id() {
        return ss01Id;
    }

    public void setSs01Id(String ss01Id) {
        this.ss01Id = ss01Id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getOpUnit() {
        return opUnit;
    }

    public void setOpUnit(String opUnit) {
        this.opUnit = opUnit;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNameJ() {
        return projectNameJ;
    }

    public void setProjectNameJ(String projectNameJ) {
        this.projectNameJ = projectNameJ;
    }
}
