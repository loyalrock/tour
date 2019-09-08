package com.manager.entry.common;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.manager.entry.system.User;
import com.manager.util.Delete;
import com.manager.util.UpdateStatusGroup;
import org.apache.shiro.SecurityUtils;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 公共字段继承
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonEntry {

    @NotBlank(message = "启用状态缺失", groups = {UpdateStatusGroup.class})
    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String deleteFlag;

    public CommonEntry() {
    }

    public CommonEntry(String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        this.status = status;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
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
        this.deleteFlag = deleteFlag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static CommonEntry insert() {
        // 当前登录用户
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        Date now = new Date();

        CommonEntry commonEntry = new CommonEntry(
                User.ENABLE,
                currentUser.getSs01Id(),
                now,
                currentUser.getSs01Id(),
                now,
                Delete.UN_DELETE);

        return commonEntry;
    }
}
