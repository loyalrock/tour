package com.manager.entry.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manager.entry.common.CommonEntry;

import java.util.Date;

public class UserRole extends CommonEntry {
    private String ss0101Id;

    private String ss01Id;

    private String userRoleId;

    public UserRole(String ss0101Id, String ss01Id, String userRoleId, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(null, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.ss0101Id = ss0101Id;
        this.ss01Id = ss01Id;
        this.userRoleId = userRoleId;
    }

    public UserRole() {
        super();
    }

    public String getSs0101Id() {
        return ss0101Id;
    }

    public void setSs0101Id(String ss0101Id) {
        this.ss0101Id = ss0101Id == null ? null : ss0101Id.trim();
    }

    public String getSs01Id() {
        return ss01Id;
    }

    public void setSs01Id(String ss01Id) {
        this.ss01Id = ss01Id == null ? null : ss01Id.trim();
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }
}
