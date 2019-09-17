package com.manager.tour.dao;

import com.manager.entry.tour.RegionShow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RegionShowMapper {
    int deleteByPrimaryKey(String sc0204Id);

    int insert(RegionShow record);

    int insertSelective(RegionShow record);

    RegionShow selectByPrimaryKey(String sc0204Id);

    int updateByPrimaryKeySelective(RegionShow record);

    int updateByPrimaryKey(RegionShow record);

    @Select("select count(*) from SC020104 where DIST_SOURCE = #{distSource}")
    int selectCount(@Param("distSource") String distSource);

    int insertAll(@Param("regionShows")List<RegionShow> regionShows);

    int deleteNotIn(@Param("ids") List<String> ids, @Param("ss01Id") String userUid);

    int deleteAll(@Param("sc0201Id") String sc0201Id, @Param("ss01Id") String userUid);
}
