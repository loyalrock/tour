package com.manager.system.dao;

import com.manager.entry.system.UserProject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserProjectMapper {
    int deleteByPrimaryKey(String ss0102Id);

    int insert(UserProject record);

    int insertSelective(UserProject record);

    UserProject selectByPrimaryKey(String ss0102Id);

    int updateByPrimaryKeySelective(UserProject record);

    int updateByPrimaryKey(UserProject record);

    int updateByUserUid(UserProject userProject);

    UserProject selectProjectBySs01Id(@Param("ss01Id") String ss01Id);
}