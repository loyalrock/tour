package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;

import java.util.Date;

public class ImageShow extends CommonEntry {
    private String sc0202Id;

    private String picSource;

    private String picNum;

    private String picName;

    private String appUrl;

    public ImageShow(String sc0202Id, String picSource, String picNum, String picName, String appUrl, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sc0202Id = sc0202Id;
        this.picSource = picSource;
        this.picNum = picNum;
        this.picName = picName;
        this.appUrl = appUrl;
    }

    public ImageShow() {
        super();
    }

    public String getSc0202Id() {
        return sc0202Id;
    }

    public void setSc0202Id(String sc0202Id) {
        this.sc0202Id = sc0202Id == null ? null : sc0202Id.trim();
    }

    public String getPicSource() {
        return picSource;
    }

    public void setPicSource(String picSource) {
        this.picSource = picSource == null ? null : picSource.trim();
    }

    public String getPicNum() {
        return picNum;
    }

    public void setPicNum(String picNum) {
        this.picNum = picNum == null ? null : picNum.trim();
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl == null ? null : appUrl.trim();
    }
}
