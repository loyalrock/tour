package com.manager.tour.dao;

import com.manager.entry.tour.DocumentShow;

public interface DocumentShowMapper {
    int deleteByPrimaryKey(String sc0201Id);

    int insert(DocumentShow record);

    int insertSelective(DocumentShow record);

    DocumentShow selectByPrimaryKey(String sc0201Id);

    int updateByPrimaryKeySelective(DocumentShow record);

    int updateByPrimaryKey(DocumentShow record);
}