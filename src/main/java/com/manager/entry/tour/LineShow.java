package com.manager.entry.tour;

import java.util.Date;

public class LineShow {
    private String sc0203Id;

    private String lineSource;

    private String lineNum;

    private String lineName;

    private Integer lineStartLong;

    private Integer lineStartLat;

    private Integer lineEndLong;

    private Integer lineEndLat;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String deleteFlag;

    public LineShow(String sc0203Id, String lineSource, String lineNum, String lineName, Integer lineStartLong, Integer lineStartLat, Integer lineEndLong, Integer lineEndLat, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        this.sc0203Id = sc0203Id;
        this.lineSource = lineSource;
        this.lineNum = lineNum;
        this.lineName = lineName;
        this.lineStartLong = lineStartLong;
        this.lineStartLat = lineStartLat;
        this.lineEndLong = lineEndLong;
        this.lineEndLat = lineEndLat;
        this.status = status;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
    }

    public LineShow() {
        super();
    }

    public String getSc0203Id() {
        return sc0203Id;
    }

    public void setSc0203Id(String sc0203Id) {
        this.sc0203Id = sc0203Id == null ? null : sc0203Id.trim();
    }

    public String getLineSource() {
        return lineSource;
    }

    public void setLineSource(String lineSource) {
        this.lineSource = lineSource == null ? null : lineSource.trim();
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum == null ? null : lineNum.trim();
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName == null ? null : lineName.trim();
    }

    public Integer getLineStartLong() {
        return lineStartLong;
    }

    public void setLineStartLong(Integer lineStartLong) {
        this.lineStartLong = lineStartLong;
    }

    public Integer getLineStartLat() {
        return lineStartLat;
    }

    public void setLineStartLat(Integer lineStartLat) {
        this.lineStartLat = lineStartLat;
    }

    public Integer getLineEndLong() {
        return lineEndLong;
    }

    public void setLineEndLong(Integer lineEndLong) {
        this.lineEndLong = lineEndLong;
    }

    public Integer getLineEndLat() {
        return lineEndLat;
    }

    public void setLineEndLat(Integer lineEndLat) {
        this.lineEndLat = lineEndLat;
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