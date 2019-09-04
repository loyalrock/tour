package com.manager.system.dao;

import com.manager.entry.system.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    int deleteByPrimaryKey(String ss01Id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String ss01Id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserByUserId(@Param("userId") String userId);
}