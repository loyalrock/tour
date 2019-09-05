package com.manager.tour.dao;

import com.manager.entry.tour.LineShow;

public interface LineShowMapper {
    int deleteByPrimaryKey(String sc0202Id);

    int insert(LineShow record);

    int insertSelective(LineShow record);

    LineShow selectByPrimaryKey(String sc0202Id);

    int updateByPrimaryKeySelective(LineShow record);

    int updateByPrimaryKey(LineShow record);
}