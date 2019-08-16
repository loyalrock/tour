package com.manager.entry.system;

import java.util.Date;

public class Role {
    private Integer id;

    private String uid;

    private String roleName;

    private String remark;

    private Byte status;

    private Long createTime;

    private Date createDate;

    private Long lastUpdateTime;

    private Date lastUpdateDate;

    public Role(Integer id, String uid, String roleName, String remark, Byte status, Long createTime, Date createDate, Long lastUpdateTime, Date lastUpdateDate) {
        this.id = id;
        this.uid = uid;
        this.roleName = roleName;
        this.remark = remark;
        this.status = status;
        this.createTime = createTime;
        this.createDate = createDate;
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}