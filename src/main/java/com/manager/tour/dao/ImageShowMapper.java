package com.manager.tour.dao;

import com.manager.entry.tour.ImageShow;

public interface ImageShowMapper {
    int deleteByPrimaryKey(String sc0202Id);

    int insert(ImageShow record);

    int insertSelective(ImageShow record);

    ImageShow selectByPrimaryKey(String sc0202Id);

    int updateByPrimaryKeySelective(ImageShow record);

    int updateByPrimaryKey(ImageShow record);
}