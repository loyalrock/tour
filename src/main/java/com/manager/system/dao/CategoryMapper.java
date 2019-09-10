package com.manager.system.dao;

import com.manager.entry.system.Category;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper {
    int insert(Category record);

    int insertSelective(Category record);

    @ResultMap("BaseResultMap")
    @Select("select * from SS05 where CLASSIFY = #{classify}")
    List<Category> selectByClassify(String classify);
}
