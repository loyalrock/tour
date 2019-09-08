package com.manager.entry.system;

import com.manager.entry.common.CommonEntry;

import java.util.Date;

public class Role extends CommonEntry {
    private String ss02Id;

    private String userRoleId;

    private String userRoleName;

    private String remarks;

    public Role(String ss02Id, String userRoleId, String userRoleName, String remarks, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.ss02Id = ss02Id;
        this.userRoleId = userRoleId;
        this.userRoleName = userRoleName;
        this.remarks = remarks;
    }

    public Role() {
        super();
    }

    public String getSs02Id() {
        return ss02Id;
    }

    public void setSs02Id(String ss02Id) {
        this.ss02Id = ss02Id == null ? null : ss02Id.trim();
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName == null ? null : userRoleName.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
