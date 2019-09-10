package com.manager.system.dao;

import com.manager.entry.system.CategoryDict;

public interface CategoryDictMapper {
    int insert(CategoryDict record);

    int insertSelective(CategoryDict record);
}