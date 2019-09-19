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
}
