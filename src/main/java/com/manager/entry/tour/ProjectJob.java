package com.manager.entry.tour;

import com.manager.entry.common.CommonEntry;
import com.manager.util.InsertGroup;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * 项目任务表
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

    private String superPNo;

    private String superPLevel;

    private String sysNo;

    private String superPCheck;

    private String superPExp;

    private String superPCont;

    private Integer superPScore;

    private String opUnit;

    private String showNo;

    private String ifFile;

    private String ifPic;

    private String ifLine;

    private String ifDist;

    private Integer score;

    private Date enableTime;

    private Date deactiTime;

    private List<UploadDataFile> uploadDataFiles;

    private List<ImageShow> imageShows;

    private List<DocumentShow> documentShows;

    private List<LineShow> lineShows;

    private List<RegionShow> regionShows;

    public List<UploadDataFile> getUploadDataFiles() {
        return uploadDataFiles;
    }

    public void setUploadDataFiles(List<UploadDataFile> uploadDataFiles) {
        this.uploadDataFiles = uploadDataFiles;
    }

    public List<ImageShow> getImageShows() {
        return imageShows;
    }

    public void setImageShows(List<ImageShow> imageShows) {
        this.imageShows = imageShows;
    }

    public List<DocumentShow> getDocumentShows() {
        return documentShows;
    }

    public void setDocumentShows(List<DocumentShow> documentShows) {
        this.documentShows = documentShows;
    }

    public List<LineShow> getLineShows() {
        return lineShows;
    }

    public void setLineShows(List<LineShow> lineShows) {
        this.lineShows = lineShows;
    }

    public List<RegionShow> getRegionShows() {
        return regionShows;
    }

    public void setRegionShows(List<RegionShow> regionShows) {
        this.regionShows = regionShows;
    }

    public ProjectJob(String sc02Id, String projectNo, String projectName, String projectNameJ, Integer projectLong, Integer projectLat, String indexPic, String superPNo, String superPLevel, String sysNo, String superPCheck, String superPExp, String superPCont, Integer superPScore, String opUnit, String status, String showNo, String ifFile, String ifPic, String ifLine, String ifDist, Integer score, Date enableTime, Date deactiTime, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sc02Id = sc02Id;
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.projectNameJ = projectNameJ;
        this.projectLong = projectLong;
        this.projectLat = projectLat;
        this.indexPic = indexPic;
        this.superPNo = superPNo;
        this.superPLevel = superPLevel;
        this.sysNo = sysNo;
        this.superPCheck = superPCheck;
        this.superPExp = superPExp;
        this.superPCont = superPCont;
        this.superPScore = superPScore;
        this.opUnit = opUnit;
        this.showNo = showNo;
        this.ifFile = ifFile;
        this.ifPic = ifPic;
        this.ifLine = ifLine;
        this.ifDist = ifDist;
        this.score = score;
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

    public String getSuperPNo() {
        return superPNo;
    }

    public void setSuperPNo(String superPNo) {
        this.superPNo = superPNo == null ? null : superPNo.trim();
    }

    public String getSuperPLevel() {
        return superPLevel;
    }

    public void setSuperPLevel(String superPLevel) {
        this.superPLevel = superPLevel == null ? null : superPLevel.trim();
    }

    public String getSysNo() {
        return sysNo;
    }

    public void setSysNo(String sysNo) {
        this.sysNo = sysNo == null ? null : sysNo.trim();
    }

    public String getSuperPCheck() {
        return superPCheck;
    }

    public void setSuperPCheck(String superPCheck) {
        this.superPCheck = superPCheck == null ? null : superPCheck.trim();
    }

    public String getSuperPExp() {
        return superPExp;
    }

    public void setSuperPExp(String superPExp) {
        this.superPExp = superPExp == null ? null : superPExp.trim();
    }

    public String getSuperPCont() {
        return superPCont;
    }

    public void setSuperPCont(String superPCont) {
        this.superPCont = superPCont == null ? null : superPCont.trim();
    }

    public Integer getSuperPScore() {
        return superPScore;
    }

    public void setSuperPScore(Integer superPScore) {
        this.superPScore = superPScore;
    }

    public String getOpUnit() {
        return opUnit;
    }

    public void setOpUnit(String opUnit) {
        this.opUnit = opUnit == null ? null : opUnit.trim();
    }

    public String getShowNo() {
        return showNo;
    }

    public void setShowNo(String showNo) {
        this.showNo = showNo == null ? null : showNo.trim();
    }

    public String getIfFile() {
        return ifFile;
    }

    public void setIfFile(String ifFile) {
        this.ifFile = ifFile == null ? null : ifFile.trim();
    }

    public String getIfPic() {
        return ifPic;
    }

    public void setIfPic(String ifPic) {
        this.ifPic = ifPic == null ? null : ifPic.trim();
    }

    public String getIfLine() {
        return ifLine;
    }

    public void setIfLine(String ifLine) {
        this.ifLine = ifLine == null ? null : ifLine.trim();
    }

    public String getIfDist() {
        return ifDist;
    }

    public void setIfDist(String ifDist) {
        this.ifDist = ifDist == null ? null : ifDist.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
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
