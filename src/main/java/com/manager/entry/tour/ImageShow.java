package com.manager.entry.tour;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manager.entry.common.CommonEntry;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ImageShow extends CommonEntry {
    private String sc020102Id;

    private String picSource;

    private String picNum;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private String picTime;

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
}
