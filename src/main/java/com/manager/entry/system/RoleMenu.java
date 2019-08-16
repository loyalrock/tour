package com.manager.entry.system;

public class RoleMenu {
    private Integer sysRoleId;

    private Integer sysMenuId;

    public RoleMenu(Integer sysRoleId, Integer sysMenuId) {
        this.sysRoleId = sysRoleId;
        this.sysMenuId = sysMenuId;
    }

    public RoleMenu() {
        super();
    }

    public Integer getSysRoleId() {
        return sysRoleId;
    }

    public void setSysRoleId(Integer sysRoleId) {
        this.sysRoleId = sysRoleId;
    }

    public Integer getSysMenuId() {
        return sysMenuId;
    }

    public void setSysMenuId(Integer sysMenuId) {
        this.sysMenuId = sysMenuId;
    }
}