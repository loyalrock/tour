package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;

import java.util.Date;

public class ImageShow extends CommonEntry {
    private String sc020102Id;

    private String picSource;

    private String picNum;

    private String picName;

    private String appUrl;

    public ImageShow(String sc020102Id, String picSource, String picNum, String picName, String appUrl, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sc020102Id = sc020102Id;
        this.picSource = picSource;
        this.picNum = picNum;
        this.picName = picName;
        this.appUrl = appUrl;
    }

    public ImageShow() {
        super();
    }

    public String getSc020102Id() {
        return sc020102Id;
    }

    public void setSc020102Id(String sc020102Id) {
        this.sc020102Id = sc020102Id == null ? null : sc020102Id.trim();
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
