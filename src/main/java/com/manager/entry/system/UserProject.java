package com.manager.entry.system;

import lombok.Data;

import java.util.Date;

@Data
public class UserProject {
    private String ss0102Id;

    private String ss01Id;

    private String projectName;

    private String projectNameJ;

    private Integer projectLong;

    private String projectNo;

    private String opUnit;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String deleteFlag;

    public UserProject(String ss0102Id, String ss01Id, String projectNo, String opUnit, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        this.ss0102Id = ss0102Id;
        this.ss01Id = ss01Id;
        this.projectNo = projectNo;
        this.opUnit = opUnit;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
    }

    public UserProject() {
        super();
    }

}