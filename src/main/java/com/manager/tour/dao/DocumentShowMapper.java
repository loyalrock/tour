package com.manager.tour.dao;

import com.manager.entry.tour.DocumentShow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DocumentShowMapper {
    int deleteByPrimaryKey(String sc0201Id);

    int insert(DocumentShow record);

    int insertSelective(DocumentShow record);

    DocumentShow selectByPrimaryKey(String sc0201Id);

    int updateByPrimaryKeySelective(DocumentShow record);

    int updateByPrimaryKey(DocumentShow record);

    @Select("select count(*) from SC0201 where FILE_SOURCE = #{fileSource}")
    int selectCount(@Param("fileSource") String fileSource);
}
