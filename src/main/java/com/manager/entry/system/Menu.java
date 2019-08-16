package com.manager.entry.system;

import java.util.Date;

public class Menu {
    private Integer id;

    private Integer parentId;

    private String menuName;

    private String menuIcon;

    private String menuUrl;

    private Byte menuType;

    private Byte menuOrder;

    private String remark;

    private Byte status;

    private Long createTime;

    private Date createDate;

    private Long lastUpdateTime;

    private Date lastUpdateDate;

    public Menu(Integer id, Integer parentId, String menuName, String menuIcon, String menuUrl, Byte menuType, Byte menuOrder, String remark, Byte status, Long createTime, Date createDate, Long lastUpdateTime, Date lastUpdateDate) {
        this.id = id;
        this.parentId = parentId;
        this.menuName = menuName;
        this.menuIcon = menuIcon;
        this.menuUrl = menuUrl;
        this.menuType = menuType;
        this.menuOrder = menuOrder;
        this.remark = remark;
        this.status = status;
        this.createTime = createTime;
        this.createDate = createDate;
        this.lastUpdateTime = lastUpdateTime;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Menu() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon == null ? null : menuIcon.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Byte getMenuType() {
        return menuType;
    }

    public void setMenuType(Byte menuType) {
        this.menuType = menuType;
    }

    public Byte getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Byte menuOrder) {
        this.menuOrder = menuOrder;
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