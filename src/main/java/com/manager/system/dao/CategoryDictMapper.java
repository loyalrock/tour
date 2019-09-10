package com.manager.system.dao;

import com.manager.entry.system.CategoryDict;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryDictMapper {
    int insert(CategoryDict record);

    int insertSelective(CategoryDict record);

    @Delete("DELETE FROM SS0305 WHERE SS03_ID = #{dictUid}")
    int deleteByDictUid(@Param("dictUid") String dictUid);

    int insertList(@Param("categoryDicts") List<CategoryDict> categoryDicts);
}
