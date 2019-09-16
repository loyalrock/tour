package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;
import com.manager.util.group.InsertGroup;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

/**
 * 项目
 */
public class ProjectJob extends CommonEntry {
    private String sc02Id;

    @NotBlank(message = "编号缺失", groups = {InsertGroup.class})
    private String projectNo;

    @NotBlank(message = "项目名称缺失", groups = {InsertGroup.class})
    private String projectName;

    @NotBlank(message = "项目简称缺失", groups = {InsertGroup.class})
    private String projectNameJ;

    @NotBlank(message = "地理位置（经度）缺失", groups = {InsertGroup.class})
    private Integer projectLong;

    @NotBlank(message = "地理位置（纬度）缺失", groups = {InsertGroup.class})
    private Integer projectLat;

    private String indexPic;

    private Date enableTime;

    private Date deactiTime;

    /**
     * 关联项目
     */
    @NotEmpty(message = "未添加维护穿件内容", groups = {InsertGroup.class})
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

    public String getSc02Id() {
        return sc02Id;
    }

    public void setSc02Id(String sc02Id) {
        this.sc02Id = sc02Id == null ? null : sc02Id.trim();
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo == null ? null : projectNo.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectNameJ() {
        return projectNameJ;
    }

    public void setProjectNameJ(String projectNameJ) {
        this.projectNameJ = projectNameJ == null ? null : projectNameJ.trim();
    }

    public Integer getProjectLong() {
        return projectLong;
    }

    public void setProjectLong(Integer projectLong) {
        this.projectLong = projectLong;
    }

    public Integer getProjectLat() {
        return projectLat;
    }

    public void setProjectLat(Integer projectLat) {
        this.projectLat = projectLat;
    }

    public String getIndexPic() {
        return indexPic;
    }

    public void setIndexPic(String indexPic) {
        this.indexPic = indexPic == null ? null : indexPic.trim();
    }

    public Date getEnableTime() {
        return enableTime;
    }

    public void setEnableTime(Date enableTime) {
        this.enableTime = enableTime;
    }

    public Date getDeactiTime() {
        return deactiTime;
    }

    public void setDeactiTime(Date deactiTime) {
        this.deactiTime = deactiTime;
    }

}
