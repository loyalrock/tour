package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;

import java.util.Date;

public class DocumentShow extends CommonEntry {
    private String sc0201Id;

    private String fileSource;

    private String fileNum;

    private String fileName;

    private String fileUrl;

    public DocumentShow(String sc0201Id, String fileSource, String fileNum, String fileName, String fileUrl, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sc0201Id = sc0201Id;
        this.fileSource = fileSource;
        this.fileNum = fileNum;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public DocumentShow() {
        super();
    }

    public String getSc0201Id() {
        return sc0201Id;
    }

    public void setSc0201Id(String sc0201Id) {
        this.sc0201Id = sc0201Id == null ? null : sc0201Id.trim();
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
