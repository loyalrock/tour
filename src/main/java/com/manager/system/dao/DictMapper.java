package com.manager.system.dao;

import com.manager.entry.system.Dict;

public interface DictMapper {
    int deleteByPrimaryKey(String ss03Id);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(String ss03Id);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);
}