package com.manager.entry.tour;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manager.entry.common.CommonEntry;
import com.manager.util.group.InsertGroup;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 项目
 */
@Data
public class ProjectJob extends CommonEntry {
    private String sc02Id;

    @NotBlank(message = "编号缺失", groups = {InsertGroup.class})
    private String projectNo;

    @NotBlank(message = "项目名称缺失", groups = {InsertGroup.class})
    private String projectName;

    @NotBlank(message = "项目简称缺失", groups = {InsertGroup.class})
    private String projectNameJ;

    @NotNull(message = "地理位置缺失", groups = {InsertGroup.class})
    private Integer projectLong;

    private Integer projectLat;

    private String indexPic;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date enableTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date deactiTime;

    /**
     * 关联项目
     */
    @NotEmpty(message = "未添加维护内容", groups = {InsertGroup.class})
    private List<ProjectContent> projectContents;

    /**
     * 首页图片
     */
    private List<UploadDataFile> uploadDataFiles;

    public List<UploadDataFile> getUploadDataFiles() {
        return uploadDataFiles;
    }

    public void setUploadDataFiles(List<UploadDataFile> uploadDataFiles) {
        this.uploadDataFiles = uploadDataFiles;
    }

    public List<ProjectContent> getProjectContents() {
        return projectContents;
    }

    public void setProjectContents(List<ProjectContent> projectContents) {
        this.projectContents = projectContents;
    }

    public ProjectJob(String sc02Id, String projectNo, String projectName, String projectNameJ, Integer projectLong, Integer projectLat, String indexPic, Date enableTime, Date deactiTime, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sc02Id = sc02Id;
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.projectNameJ = projectNameJ;
        this.projectLong = projectLong;
        this.projectLat = projectLat;
        this.indexPic = indexPic;
        this.enableTime = enableTime;
        this.deactiTime = deactiTime;
    }

    public ProjectJob() {
        super();
    }
}
