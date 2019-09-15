package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;

import java.util.Date;

public class RegionShow extends CommonEntry {
    private String sc0204Id;

    private String distSource;

    private String distNo;

    private String distClass;

    private String distSecCalss;

    private String distName;

    private Integer distStartLong;

    private Integer distStartLat;

    private String distAdres;

    private String distPicUrl;

    private String distTel;

    private String distExp;

    public RegionShow(String sc0204Id, String distSource, String distNo, String distClass, String distSecCalss, String distName, Integer distStartLong, Integer distStartLat, String distAdres, String distPicUrl, String distTel, String distExp, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sc0204Id = sc0204Id;
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

    public String getSc0204Id() {
        return sc0204Id;
    }

    public void setSc0204Id(String sc0204Id) {
        this.sc0204Id = sc0204Id == null ? null : sc0204Id.trim();
    }

    public String getDistSource() {
        return distSource;
    }

    public void setDistSource(String distSource) {
        this.distSource = distSource == null ? null : distSource.trim();
    }

    public String getDistNo() {
        return distNo;
    }

    public void setDistNo(String distNo) {
        this.distNo = distNo == null ? null : distNo.trim();
    }

    public String getDistClass() {
        return distClass;
    }

    public void setDistClass(String distClass) {
        this.distClass = distClass == null ? null : distClass.trim();
    }

    public String getDistSecCalss() {
        return distSecCalss;
    }

    public void setDistSecCalss(String distSecCalss) {
        this.distSecCalss = distSecCalss == null ? null : distSecCalss.trim();
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName == null ? null : distName.trim();
    }

    public Integer getDistStartLong() {
        return distStartLong;
    }

    public void setDistStartLong(Integer distStartLong) {
        this.distStartLong = distStartLong;
    }

    public Integer getDistStartLat() {
        return distStartLat;
    }

    public void setDistStartLat(Integer distStartLat) {
        this.distStartLat = distStartLat;
    }

    public String getDistAdres() {
        return distAdres;
    }

    public void setDistAdres(String distAdres) {
        this.distAdres = distAdres == null ? null : distAdres.trim();
    }

    public String getDistPicUrl() {
        return distPicUrl;
    }

    public void setDistPicUrl(String distPicUrl) {
        this.distPicUrl = distPicUrl == null ? null : distPicUrl.trim();
    }

    public String getDistTel() {
        return distTel;
    }

    public void setDistTel(String distTel) {
        this.distTel = distTel == null ? null : distTel.trim();
    }

    public String getDistExp() {
        return distExp;
    }

    public void setDistExp(String distExp) {
        this.distExp = distExp == null ? null : distExp.trim();
    }
}
