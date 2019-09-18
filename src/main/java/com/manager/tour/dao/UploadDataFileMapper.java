package com.manager.tour.dao;

import com.manager.entry.tour.UploadDataFile;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UploadDataFileMapper {
    int deleteByPrimaryKey(String sfj01Id);

    int insert(UploadDataFile record);

    int insertSelective(UploadDataFile record);

    UploadDataFile selectByPrimaryKey(String sfj01Id);

    int updateByPrimaryKeySelective(UploadDataFile record);

    int updateByPrimaryKey(UploadDataFile record);

    @Select("select count(*) from SFJ01 where APP_SOURCE = #{appSource}")
    int selectCount(@Param("appSource") String appSource);

    /**
     * 批量新增
     * @param uploadDataFiles
     * @return
     */
    int insertAll(@Param("uploadDataFiles") List<UploadDataFile> uploadDataFiles);

    int deleteAll(@Param("projectNo") String projectNo, @Param("ids") List<String> ids, @Param("ss01Id") String userUid);
}
