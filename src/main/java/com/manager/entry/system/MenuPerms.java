package com.manager.entry.system;

public class MenuPerms {
    private Integer sysMenuId;

    private String permsCode;

    private String permsName;

    private String remark;

    public MenuPerms(Integer sysMenuId, String permsCode, String permsName, String remark) {
        this.sysMenuId = sysMenuId;
        this.permsCode = permsCode;
        this.permsName = permsName;
        this.remark = remark;
    }

    public MenuPerms() {
        super();
    }

    public Integer getSysMenuId() {
        return sysMenuId;
    }

    public void setSysMenuId(Integer sysMenuId) {
        this.sysMenuId = sysMenuId;
    }

    public String getPermsCode() {
        return permsCode;
    }

    public void setPermsCode(String permsCode) {
        this.permsCode = permsCode == null ? null : permsCode.trim();
    }

    public String getPermsName() {
        return permsName;
    }

    public void setPermsName(String permsName) {
        this.permsName = permsName == null ? null : permsName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}