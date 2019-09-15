package com.manager.tour.dao;

import com.manager.entry.tour.ImageShow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ImageShowMapper {
    int deleteByPrimaryKey(String sc0202Id);

    int insert(ImageShow record);

    int insertSelective(ImageShow record);

    ImageShow selectByPrimaryKey(String sc0202Id);

    int updateByPrimaryKeySelective(ImageShow record);

    int updateByPrimaryKey(ImageShow record);

    @Select("select count(*) from SC0202 where PIC_SOURCE = #{picSource}")
    int selectCount(@Param("picSource") String picSource);
}
