package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;

import java.util.Date;

public class LineShow extends CommonEntry {
    private String sc020103Id;

    private String lineSource;

    private String lineNum;

    private String lineName;

    private Integer lineStartLong;

    private Integer lineStartLat;

    private Integer lineEndLong;

    private Integer lineEndLat;

    public LineShow(String sc020103Id, String lineSource, String lineNum, String lineName, Integer lineStartLong, Integer lineStartLat, Integer lineEndLong, Integer lineEndLat, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        this.sc020103Id = sc020103Id;
        this.lineSource = lineSource;
        this.lineNum = lineNum;
        this.lineName = lineName;
        this.lineStartLong = lineStartLong;
        this.lineStartLat = lineStartLat;
        this.lineEndLong = lineEndLong;
        this.lineEndLat = lineEndLat;
    }

    public LineShow() {
        super();
    }

    public String getSc020103Id() {
        return sc020103Id;
    }

    public void setSc020103Id(String sc020103Id) {
        this.sc020103Id = sc020103Id == null ? null : sc020103Id.trim();
    }

    public String getLineSource() {
        return lineSource;
    }

    public void setLineSource(String lineSource) {
        this.lineSource = lineSource == null ? null : lineSource.trim();
    }

    public String getLineNum() {
        return lineNum;
    }

    public void setLineNum(String lineNum) {
        this.lineNum = lineNum == null ? null : lineNum.trim();
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName == null ? null : lineName.trim();
    }

    public Integer getLineStartLong() {
        return lineStartLong;
    }

    public void setLineStartLong(Integer lineStartLong) {
        this.lineStartLong = lineStartLong;
    }

    public Integer getLineStartLat() {
        return lineStartLat;
    }

    public void setLineStartLat(Integer lineStartLat) {
        this.lineStartLat = lineStartLat;
    }

    public Integer getLineEndLong() {
        return lineEndLong;
    }

    public void setLineEndLong(Integer lineEndLong) {
        this.lineEndLong = lineEndLong;
    }

    public Integer getLineEndLat() {
        return lineEndLat;
    }

    public void setLineEndLat(Integer lineEndLat) {
        this.lineEndLat = lineEndLat;
    }
}
