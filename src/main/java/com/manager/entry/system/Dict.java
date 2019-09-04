package com.manager.entry.system;

import java.util.Date;

public class Dict {
    private String ss03Id;

    private String dirId;

    private String dirName;

    private String dirExp;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String deleteFlag;

    public Dict(String ss03Id, String dirId, String dirName, String dirExp, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        this.ss03Id = ss03Id;
        this.dirId = dirId;
        this.dirName = dirName;
        this.dirExp = dirExp;
        this.status = status;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
    }

    public Dict() {
        super();
    }

    public String getSs03Id() {
        return ss03Id;
    }

    public void setSs03Id(String ss03Id) {
        this.ss03Id = ss03Id == null ? null : ss03Id.trim();
    }

    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId == null ? null : dirId.trim();
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName == null ? null : dirName.trim();
    }

    public String getDirExp() {
        return dirExp;
    }

    public void setDirExp(String dirExp) {
        this.dirExp = dirExp == null ? null : dirExp.trim();
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