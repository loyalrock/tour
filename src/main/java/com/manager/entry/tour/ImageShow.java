package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;
import lombok.Data;

import java.util.Date;

@Data
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
}
