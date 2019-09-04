package com.manager.entry.system;

import java.util.Date;

public class UserProject {
    private String ss0102Id;

    private String ss01Id;

    private String projectNo;

    private String opUnit;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String deleteFlag;

    public UserProject(String ss0102Id, String ss01Id, String projectNo, String opUnit, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        this.ss0102Id = ss0102Id;
        this.ss01Id = ss01Id;
        this.projectNo = projectNo;
        this.opUnit = opUnit;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
    }

    public UserProject() {
        super();
    }

    public String getSs0102Id() {
        return ss0102Id;
    }

    public void setSs0102Id(String ss0102Id) {
        this.ss0102Id = ss0102Id == null ? null : ss0102Id.trim();
    }

    public String getSs01Id() {
        return ss01Id;
    }

    public void setSs01Id(String ss01Id) {
        this.ss01Id = ss01Id == null ? null : ss01Id.trim();
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getOpUnit() {
        return opUnit;
    }

    public void setOpUnit(String opUnit) {
        this.opUnit = opUnit == null ? null : opUnit.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

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