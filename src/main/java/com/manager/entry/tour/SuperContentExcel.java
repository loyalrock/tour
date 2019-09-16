package com.manager.entry.tour;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.manager.util.Delete;

import java.util.Date;

/**
 * 描述
 *
 * @auth0r nosign
 * @date 2019/09/12
 */
public class SuperContentExcel extends BaseRowModel {

    @ExcelProperty(index = 0, value = "主键")
    private String sc01Id;

    @ExcelProperty(index = 1, value = "创建内容编号")
    private String superPNo;

    @ExcelProperty(index = 2, value = "创建内容层级")
    private String superPLevel;

    @ExcelProperty(index = 3, value = "系统序号")
    private String sysNo;

    @ExcelProperty(index = 4, value = "创建内容名称")
    private String superPCheck;

    @ExcelProperty(index = 5, value = "内容说明")
    private String superPExp;

    @ExcelProperty(index = 6, value = "项目分值")
    private String superPScore;

    @ExcelProperty(index = 7, value = "默认添加")
    private String ifAdd;

    @ExcelProperty(index = 8, format = "yyyy/MM/dd", value = "启用时间")
    private Date enableTime;

    @ExcelProperty(index = 9, format = "yyyy/MM/dd", value = "停用时间")
    private Date deactiTime;

    @ExcelProperty(index = 10, value = "状态")
    private String status;

    @ExcelProperty(index = 11, value = "新增用户")
    private String createUser;

    @ExcelProperty(index = 12, format = "yyyy/MM/dd", value = "新增时间")
    private Date createTime;

    @ExcelProperty(index = 13, value = "修改用户")
    private String updateUser;

    @ExcelProperty(index = 14, format = "yyyy/MM/dd", value = "修改时间")
    private Date updateTime;

    @ExcelProperty(index = 15, value = "删除标识")
    private String deleteFlag;

    @ExcelProperty(index = 16, value = "错误信息")
    private String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        if (deleteFlag == null || "".equals(deleteFlag)) {
            deleteFlag = Delete.UN_DELETE;
        }
        this.deleteFlag = deleteFlag;
    }
}
