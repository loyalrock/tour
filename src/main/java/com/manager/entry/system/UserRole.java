package com.manager.entry.system;

public class UserRole {
    private String sysUserUid;

    private Integer sysRoleId;

    public UserRole(String sysUserUid, Integer sysRoleId) {
        this.sysUserUid = sysUserUid;
        this.sysRoleId = sysRoleId;
    }

    public UserRole() {
        super();
    }

    public String getSysUserUid() {
        return sysUserUid;
    }

    public void setSysUserUid(String sysUserUid) {
        this.sysUserUid = sysUserUid == null ? null : sysUserUid.trim();
    }

    public Integer getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
    }
}