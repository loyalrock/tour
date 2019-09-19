package com.manager.entry.system;

/**
 * 用户管理查询参数
 */
public class UserManagerQuery {

    /**
     * 状态
     */
    private String status;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 角色
     */
    private String userRoleId;

    /**
     * 项目编号
     */
    private String projectNo;

    /**
     * 项目名称
     */
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }
}
