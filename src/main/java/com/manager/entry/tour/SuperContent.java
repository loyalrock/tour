package com.manager.entry.tour;

import java.util.Date;

public class SuperContent {
    private String sc01Id;

    private String superPNo;

    private String superPLevel;

    private String sysNo;

    private String superPCheck;

    private String superPExp;

    private String superPScore;

    private String ifAdd;

    private Date enableTime;

    private Date deactiTime;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String deleteFlag;

    public SuperContent(String sc01Id, String superPNo, String superPLevel, String sysNo, String superPCheck, String superPExp, String superPScore, String ifAdd, Date enableTime, Date deactiTime, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        this.sc01Id = sc01Id;
        this.superPNo = superPNo;
        this.superPLevel = superPLevel;
        this.sysNo = sysNo;
        this.superPCheck = superPCheck;
        this.superPExp = superPExp;
        this.superPScore = superPScore;
        this.ifAdd = ifAdd;
        this.enableTime = enableTime;
        this.deactiTime = deactiTime;
        this.status = status;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
    }

    public SuperContent() {
        super();
    }

    public String getSc01Id() {
        return sc01Id;
    }

    public void setSc01Id(String sc01Id) {
        this.sc01Id = sc01Id == null ? null : sc01Id.trim();
    }

    public String getSuperPNo() {
        return superPNo;
    }

    public void setSuperPNo(String superPNo) {
        this.superPNo = superPNo == null ? null : superPNo.trim();
    }

    public String getSuperPLevel() {
        return superPLevel;
    }

    public void setSuperPLevel(String superPLevel) {
        this.superPLevel = superPLevel == null ? null : superPLevel.trim();
    }

    public String getSysNo() {
        return sysNo;
    }

    public void setSysNo(String sysNo) {
        this.sysNo = sysNo == null ? null : sysNo.trim();
    }

    public String getSuperPCheck() {
        return superPCheck;
    }

    public void setSuperPCheck(String superPCheck) {
        this.superPCheck = superPCheck == null ? null : superPCheck.trim();
    }

    public String getSuperPExp() {
        return superPExp;
    }

    public void setSuperPExp(String superPExp) {
        this.superPExp = superPExp == null ? null : superPExp.trim();
    }

    public String getSuperPScore() {
        return superPScore;
    }

    public void setSuperPScore(String superPScore) {
        this.superPScore = superPScore == null ? null : superPScore.trim();
    }

    public String getIfAdd() {
        return ifAdd;
    }

    public void setIfAdd(String ifAdd) {
        this.ifAdd = ifAdd == null ? null : ifAdd.trim();
    }

    public Date getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }

    public Date getDeactiTime() {
        return deactiTime;
    }

    public void setDeactiTime(Date deactiTime) {
        this.deactiTime = deactiTime;
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