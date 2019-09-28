package com.manager.entry.tour;

import com.manager.entry.common.CheckParentNo;
import com.manager.entry.common.CommonEntry;
import com.manager.util.group.InsertGroup;
import com.manager.util.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * 项目内容维护
 */
@Data
public class ProjectContent extends CommonEntry implements CheckParentNo {

    @NotBlank(message = "缺失内容维护主键", groups = {UpdateGroup.class})
    private String sc0201Id;

    @NotBlank(message = "缺失项目编号", groups = {InsertGroup.class})
    private String projectNo;

    /**
     * 项目名称
     */
    @NotBlank(message = "缺失项目名称", groups = {InsertGroup.class})
    private String projectName;

    /**
     * 项目状态
     */
    private String projectStatus;

    private String nextLevel;

    /**
     * 项目主键
     */
    private String sc02Id;

    @NotBlank(message = "缺失维护内容编号", groups = {InsertGroup.class})
    private String superPNo;

    private String superParent;

    @NotBlank(message = "缺失维护内容层级", groups = {InsertGroup.class})
    private String superPLevel;

    @NotBlank(message = "缺失维护内容系统编号", groups = {InsertGroup.class})
    private String sysNo;

    @NotBlank(message = "缺失维护内容", groups = {InsertGroup.class})
    private String superPCheck;

    private String superPExplain;

    private String superPIndicator;

    private String superPStandard;

    private String superPExp;

    private String superPCont;

    @Min(value = 0, message = "分值不能小于0", groups = {InsertGroup.class})
    private Integer superPScore;

    private String opUnit;

    private String showNo;

    private String ifFile;

    private String ifPic;

    private String ifLine;

    private String ifDist;

    private Integer score;

    private Integer totalSuperScore;

    private Integer totalScore;

    private List<ProjectContent> projectContents;

    private List<ImageShow> imageShows;

    private List<DocumentShow> documentShows;

    private List<LineShow> lineShows;

    private List<RegionShow> regionShows;


    public ProjectContent(String sc0201Id, String projectNo, String superPNo, String superParent, String superPLevel, String sysNo, String superPCheck, String superPExp, String superPCont, Integer superPScore, String superPExplain, String superPIndicator, String superPStandard, String opUnit, String status, String showNo, String ifFile, String ifPic, String ifLine, String ifDist, Integer score, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        this.sc0201Id = sc0201Id;
        this.projectNo = projectNo;
        this.superPNo = superPNo;
        this.superParent = superParent;
        this.superPLevel = superPLevel;
        this.sysNo = sysNo;
        this.superPCheck = superPCheck;
        this.superPExp = superPExp;
        this.superPCont = superPCont;
        this.superPScore = superPScore;
        this.superPExplain = superPExplain;
        this.superPIndicator = superPIndicator;
        this.superPStandard = superPStandard;
        this.opUnit = opUnit;
        this.showNo = showNo;
        this.ifFile = ifFile;
        this.ifPic = ifPic;
        this.ifLine = ifLine;
        this.ifDist = ifDist;
        this.score = score;
    }

    public ProjectContent() {
        super();
    }
}
