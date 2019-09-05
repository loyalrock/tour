package com.manager.tour.dao;

import com.manager.entry.tour.SuperContent;

public interface SuperContentMapper {
    int deleteByPrimaryKey(String sc01Id);

    int insert(SuperContent record);

    int insertSelective(SuperContent record);

    SuperContent selectByPrimaryKey(String sc01Id);

    int updateByPrimaryKeySelective(SuperContent record);

    int updateByPrimaryKey(SuperContent record);
}