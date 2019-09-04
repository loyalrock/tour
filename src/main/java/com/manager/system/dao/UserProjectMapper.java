package com.manager.system.dao;

import com.manager.entry.system.UserProject;

public interface UserProjectMapper {
    int deleteByPrimaryKey(String ss0102Id);

    int insert(UserProject record);

    int insertSelective(UserProject record);

    UserProject selectByPrimaryKey(String ss0102Id);

    int updateByPrimaryKeySelective(UserProject record);

    int updateByPrimaryKey(UserProject record);
}