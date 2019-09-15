package com.manager.tour.dao;

import com.manager.entry.tour.UploadDataFile;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UploadDataFileMapper {
    int deleteByPrimaryKey(String sfj01Id);

    int insert(UploadDataFile record);

    int insertSelective(UploadDataFile record);

    UploadDataFile selectByPrimaryKey(String sfj01Id);

    int updateByPrimaryKeySelective(UploadDataFile record);

    int updateByPrimaryKey(UploadDataFile record);

    @Select("select count(*) from SFJ01 where APP_SOURCE = #{appSource}")
    int selectCount(@Param("appSource") String appSource);
}
