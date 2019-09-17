package com.manager.tour.dao;

import com.manager.entry.tour.LineShow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LineShowMapper {
    int deleteByPrimaryKey(String sc020103Id);

    int insert(LineShow record);

    int insertSelective(LineShow record);

    LineShow selectByPrimaryKey(String sc020103Id);

    int updateByPrimaryKeySelective(LineShow record);

    int updateByPrimaryKey(LineShow record);

    @Select("select count(*) from SC020103 where LINE_SOURCE = #{lineSource}")
    int selectCount(@Param("lineSource") String lineSource);

    int insertAll(@Param("lineShows")List<LineShow> lineShows);

    int deleteNotIn(@Param("ids") List<String> ids, @Param("ss01Id") String userUid);

    int deleteAll(@Param("sc0201Id") String sc0201Id, @Param("ss01Id") String userUid);
}
