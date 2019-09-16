package com.manager.entry.tour;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manager.entry.common.CommonEntry;
import com.manager.util.group.InsertGroup;
import com.manager.util.group.UpdateGroup;
import com.manager.util.group.UpdateStatusGroup;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

public class SuperContent extends CommonEntry {
    @NotBlank(message = "缺失主键", groups = {UpdateGroup.class})
    private String sc01Id;

    @NotEmpty(message = "修改主键缺失", groups = {UpdateStatusGroup.class})
    private List<String> sc01Ids;

    @NotBlank(message = "缺失编号", groups = {InsertGroup.class, UpdateGroup.class})
    private String superPNo;

    @NotBlank(message = "缺失层级", groups = {InsertGroup.class, UpdateGroup.class})
    private String superPLevel;

    @NotBlank(message = "缺失系统序号", groups = {InsertGroup.class, UpdateGroup.class})
    private String sysNo;

    private String superPCheck;

    private String superPExp;

    private String superPScore;

    private String ifAdd;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date enableTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date deactiTime;

    public SuperContent(String sc01Id, String superPNo, String superPLevel, String sysNo, String superPCheck, String superPExp, String superPScore, String ifAdd, Date enableTime, Date deactiTime, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.sc01Id = sc01Id;
        this.superPNo = superPNo;
        this.superPLevel = superPLevel;
        this.sysNo = sysNo;
        this.superPCheck = superPCheck;
        this.superPExp = superPExp;
        this.superPScore = superPScore;
        this.ifAdd = ifAdd;
        this.enableTime = enableTime;
        this.deactiTime = deactiTime;
    }

    public List<String> getSc01Ids() {
        return sc01Ids;
    }

    public void setSc01Ids(List<String> sc01Ids) {
        this.sc01Ids = sc01Ids;
    }

    public SuperContent() {
        super();
    }

    public String getSc01Id() {
        return sc01Id;
    }

    public void setSc01Id(String sc01Id) {
        this.sc01Id = sc01Id == null ? null : sc01Id.trim();
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

    public String getSuperPScore() {
        return superPScore;
    }

    public void setSuperPScore(String superPScore) {
        this.superPScore = superPScore == null ? null : superPScore.trim();
    }

    public String getIfAdd() {
        return ifAdd;
    }

    public void setIfAdd(String ifAdd) {
        this.ifAdd = ifAdd == null ? null : ifAdd.trim();
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
