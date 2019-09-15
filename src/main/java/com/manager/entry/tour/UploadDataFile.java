package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;

import java.util.Date;

public class UploadDataFile extends CommonEntry {
    private String sfj01Id;

    private String appSource;

    private String appNum;

    private String appName;

    private String appUrl;

    public UploadDataFile(String sfj01Id, String appSource, String appNum, String appName, String appUrl, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sfj01Id = sfj01Id;
        this.appSource = appSource;
        this.appNum = appNum;
        this.appName = appName;
        this.appUrl = appUrl;
    }

    public UploadDataFile() {
        super();
    }

    public String getSfj01Id() {
        return sfj01Id;
    }

    public void setSfj01Id(String sfj01Id) {
        this.sfj01Id = sfj01Id == null ? null : sfj01Id.trim();
    }

    public String getAppSource() {
        return appSource;
    }

    public void setAppSource(String appSource) {
        this.appSource = appSource == null ? null : appSource.trim();
    }

    public String getAppNum() {
        return appNum;
    }

    public void setAppNum(String appNum) {
        this.appNum = appNum == null ? null : appNum.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl == null ? null : appUrl.trim();
    }
}
