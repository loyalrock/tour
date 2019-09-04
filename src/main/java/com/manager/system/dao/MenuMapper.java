package com.manager.system.dao;

import com.manager.entry.system.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(String ss04Id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(String ss04Id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}