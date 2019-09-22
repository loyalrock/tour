package com.manager.entry.tour;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manager.entry.common.CommonEntry;
import com.manager.entry.common.CommonTime;
import com.manager.util.group.InsertGroup;
import com.manager.util.group.UpdateGroup;
import com.manager.util.group.UpdateStatusGroup;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
public class SuperContent extends CommonEntry implements CommonTime {
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

    private Integer totalScore;

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

    /**
     * 递归查询
     */
    private List<SuperContent> superContents;

    public List<SuperContent> getSuperContents() {
        return superContents;
    }

    public void setSuperContents(List<SuperContent> superContents) {
        this.superContents = superContents;
    }

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

    public SuperContent(){};

}
