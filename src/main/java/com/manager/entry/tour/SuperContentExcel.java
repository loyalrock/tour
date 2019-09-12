package com.manager.entry.tour;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.manager.util.InsertGroup;
import com.manager.util.UpdateGroup;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 描述
 *
 * @auth0r nosign
 * @date 2019/09/12
 */
public class SuperContentExcel extends BaseRowModel {

    @ExcelProperty(index = 0)
    private String sc01Id;

    @ExcelProperty(index = 1)
    private String superPNo;

    @ExcelProperty(index = 2)
    private String superPLevel;

    @ExcelProperty(index = 3)
    private String sysNo;

    @ExcelProperty(index = 4)
    private String superPCheck;

    @ExcelProperty(index = 5)
    private String superPExp;

    @ExcelProperty(index = 6)
    private String superPScore;

    @ExcelProperty(index = 7)
    private String ifAdd;

    @ExcelProperty(index = 8, format = "yyyy/MM/dd")
    private Date enableTime;

    @ExcelProperty(index = 9, format = "yyyy/MM/dd")
    private Date deactiTime;

    @ExcelProperty(index = 10)
    private String createUser;

    @ExcelProperty(index = 11, format = "yyyy/MM/dd")
    private Date createTime;

    public String getSc01Id() {
        return sc01Id;
    }

    public void setSc01Id(String sc01Id) {
        this.sc01Id = sc01Id;
    }

    public String getSuperPNo() {
        return superPNo;
    }

    public void setSuperPNo(String superPNo) {
        this.superPNo = superPNo;
    }

    public String getSuperPLevel() {
        return superPLevel;
    }

    public void setSuperPLevel(String superPLevel) {
        this.superPLevel = superPLevel;
    }

    public String getSysNo() {
        return sysNo;
    }

    public void setSysNo(String sysNo) {
        this.sysNo = sysNo;
    }

    public String getSuperPCheck() {
        return superPCheck;
    }

    public void setSuperPCheck(String superPCheck) {
        this.superPCheck = superPCheck;
    }

    public String getSuperPExp() {
        return superPExp;
    }

    public void setSuperPExp(String superPExp) {
        this.superPExp = superPExp;
    }

    public String getSuperPScore() {
        return superPScore;
    }

    public void setSuperPScore(String superPScore) {
        this.superPScore = superPScore;
    }

    public String getIfAdd() {
        return ifAdd;
    }

    public void setIfAdd(String ifAdd) {
        this.ifAdd = ifAdd;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
