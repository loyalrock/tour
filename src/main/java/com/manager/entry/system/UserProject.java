package com.manager.entry.system;

import com.manager.entry.common.CommonEntry;
import lombok.Data;

import java.util.Date;

@Data
public class UserProject extends CommonEntry {
    private String ss0102Id;

    private String ss01Id;

    private String projectName;

    private String projectNameJ;

    private Integer projectLong;

    private String projectExpand1;

    private String projectExpand2;

    private String projectLat;

    private String projectNo;

    private String opUnit;

    public UserProject(String ss0102Id, String ss01Id, String projectNo, String opUnit, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(null, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.ss0102Id = ss0102Id;
        this.ss01Id = ss01Id;
        this.projectNo = projectNo;
        this.opUnit = opUnit;
    }

    public UserProject() {
        super();
    }

}
