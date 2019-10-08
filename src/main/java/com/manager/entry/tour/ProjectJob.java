package com.manager.entry.tour;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manager.entry.common.CommonEntry;
import com.manager.entry.common.CommonTime;
import com.manager.entry.common.UserUtil;
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
public class ProjectJob extends CommonEntry implements CommonTime {
    private String sc02Id;

    @NotBlank(message = "编号缺失", groups = {InsertGroup.class})
    private String projectNo;

    @NotBlank(message = "项目名称缺失", groups = {InsertGroup.class})
    private String projectName;

    @NotBlank(message = "项目简称缺失", groups = {InsertGroup.class})
    private String projectNameJ;

    @NotNull(message = "地理位置缺失", groups = {InsertGroup.class})
    private Integer projectLong;

    private String projectLat;

    private String indexPic;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date enableTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date deactiTime;

    /**
     * 拓展字段 存放展示pdf
     */
    private String projectExpand1;

    /**
     * 拓展字段 存放展示pdf
     */
    private String projectExpand2;

    /**
     * 关联项目
     */
    @NotEmpty(message = "未添加维护内容", groups = {InsertGroup.class})
    private List<ProjectContent> projectContents;

    /**
     * 首页图片
     */
    private List<UploadDataFile> uploadDataFiles;

    /**
     * 地域展示
     */
    private List<RegionShow> regionShows;

    public ProjectJob(String sc02Id, String projectNo, String projectName, String projectNameJ, Integer projectLong, String projectLat, String indexPic, String projectExpand1, String projectExpand2, Date enableTime, Date deactiTime, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
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
        this.projectExpand1 = projectExpand1;
        this.projectExpand2 = projectExpand2;
    }

    public ProjectJob() {
        super();
    }
}
