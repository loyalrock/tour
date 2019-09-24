package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;
import lombok.Data;

import java.util.Date;

@Data
public class LineShow extends CommonEntry {
    private String sc020103Id;

    private String lineSource;

    private String lineNum;

    private String lineName;

    private String lineStartLong;

    private String lineStartLat;

    private String lineEndLong;

    private String lineEndLat;

    public LineShow(String sc020103Id, String lineSource, String lineNum, String lineName, String lineStartLong, String lineStartLat, String lineEndLong, String lineEndLat, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
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
}
