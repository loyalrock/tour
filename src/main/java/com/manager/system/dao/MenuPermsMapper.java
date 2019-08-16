package com.manager.system.dao;

import com.manager.entry.system.MenuPerms;

public interface MenuPermsMapper {
    int insert(MenuPerms record);

    int insertSelective(MenuPerms record);
}