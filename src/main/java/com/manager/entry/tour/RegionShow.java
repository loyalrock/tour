package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;
import lombok.Data;

import java.util.Date;

@Data
public class RegionShow extends CommonEntry {
    private String sc020104Id;

    private String distSource;

    private String distNo;

    private String distClass;

    private String distSecCalss;

    private String distName;

    private String distStartLong;

    private String distStartLat;

    private String distAdres;

    private String distPicUrl;

    private String distTel;

    private String distExp;

    public RegionShow(String sc020104Id, String distSource, String distNo, String distClass, String distSecCalss, String distName, String distStartLong, String distStartLat, String distAdres, String distPicUrl, String distTel, String distExp, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sc020104Id = sc020104Id;
        this.distSource = distSource;
        this.distNo = distNo;
        this.distClass = distClass;
        this.distSecCalss = distSecCalss;
        this.distName = distName;
        this.distStartLong = distStartLong;
        this.distStartLat = distStartLat;
        this.distAdres = distAdres;
        this.distPicUrl = distPicUrl;
        this.distTel = distTel;
        this.distExp = distExp;
    }

    public RegionShow() {
        super();
    }

}
