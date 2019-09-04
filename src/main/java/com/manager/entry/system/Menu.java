package com.manager.entry.system;

import java.util.Date;

public class Menu {
    private String ss04Id;

    private String menuId;

    private String menuOredr;

    private String menuName;

    private String menuPath;

    private String ifRootNode;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    private String deleteFlag;

    public Menu(String ss04Id, String menuId, String menuOredr, String menuName, String menuPath, String ifRootNode, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        this.ss04Id = ss04Id;
        this.menuId = menuId;
        this.menuOredr = menuOredr;
        this.menuName = menuName;
        this.menuPath = menuPath;
        this.ifRootNode = ifRootNode;
        this.status = status;
        this.createUser = createUser;
        this.createTime = createTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
        this.deleteFlag = deleteFlag;
    }

    public Menu() {
        super();
    }

    public String getSs04Id() {
        return ss04Id;
    }

    public void setSs04Id(String ss04Id) {
        this.ss04Id = ss04Id == null ? null : ss04Id.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }

    public String getMenuOredr() {
        return menuOredr;
    }

    public void setMenuOredr(String menuOredr) {
        this.menuOredr = menuOredr == null ? null : menuOredr.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath == null ? null : menuPath.trim();
    }

    public String getIfRootNode() {
        return ifRootNode;
    }

    public void setIfRootNode(String ifRootNode) {
        this.ifRootNode = ifRootNode == null ? null : ifRootNode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
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
        this.updateUser = updateUser == null ? null : updateUser.trim();
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
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }
}