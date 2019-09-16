package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;

import java.util.Date;

public class DocumentShow extends CommonEntry {
    private String sc020101Id;

    private String fileSource;

    private String fileNum;

    private String fileName;

    private String fileUrl;

    public DocumentShow(String sc020101Id, String fileSource, String fileNum, String fileName, String fileUrl, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sc020101Id = sc020101Id;
        this.fileSource = fileSource;
        this.fileNum = fileNum;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public DocumentShow() {
        super();
    }

    public String getSc020101Id() {
        return sc020101Id;
    }

    public void setSc020101Id(String sc020101Id) {
        this.sc020101Id = sc020101Id == null ? null : sc020101Id.trim();
    }

    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource == null ? null : fileSource.trim();
    }

    public String getFileNum() {
        return fileNum;
    }

    public void setFileNum(String fileNum) {
        this.fileNum = fileNum == null ? null : fileNum.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }
}
