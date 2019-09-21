package com.manager.entry.tour;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manager.entry.common.CommonEntry;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DocumentShow extends CommonEntry {
    private String sc020101Id;

    private String fileSource;

    private String fileNum;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date fileTime;

    private String fileName;

    private String fileUrl;

    public DocumentShow(String sc020101Id, String fileSource,Date fileTime, String fileNum, String fileName, String fileUrl, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sc020101Id = sc020101Id;
        this.fileTime = fileTime;
        this.fileSource = fileSource;
        this.fileNum = fileNum;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }

    public DocumentShow() {
        super();
    }
}
