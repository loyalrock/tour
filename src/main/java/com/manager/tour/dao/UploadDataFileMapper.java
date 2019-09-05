package com.manager.tour.dao;

import com.manager.entry.tour.UploadDataFile;

public interface UploadDataFileMapper {
    int deleteByPrimaryKey(String sfj01Id);

    int insert(UploadDataFile record);

    int insertSelective(UploadDataFile record);

    UploadDataFile selectByPrimaryKey(String sfj01Id);

    int updateByPrimaryKeySelective(UploadDataFile record);

    int updateByPrimaryKey(UploadDataFile record);
}