package com.manager.tour.dao;

import com.manager.entry.tour.DocumentShow;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DocumentShowMapper {
    int deleteByPrimaryKey(String sc020101Id);

    int insert(DocumentShow record);

    int insertSelective(DocumentShow record);

    DocumentShow selectByPrimaryKey(String sc020101Id);

    int updateByPrimaryKeySelective(DocumentShow record);

    int updateByPrimaryKey(DocumentShow record);

    @Select("select count(*) from SC020101 where FILE_SOURCE = #{fileSource}")
    int selectCount(@Param("fileSource") String fileSource);

    int insertAll(@Param("documentShows")List<DocumentShow> documentShows);

    int deleteNotIn(@Param("ids") List<String> ids, @Param("ss01Id") String userUid);

    int deleteAll(@Param("sc0201Id") String sc0201Id, @Param("ss01Id") String userUid);
}
