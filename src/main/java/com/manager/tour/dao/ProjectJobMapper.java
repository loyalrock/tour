package com.manager.tour.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.tour.ProjectJob;
import com.manager.entry.tour.ProjectJobQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProjectJobMapper {
    int deleteByPrimaryKey(String sc02Id);

    int insert(ProjectJob record);

    int insertSelective(ProjectJob record);

    ProjectJob selectByPrimaryKey(String sc02Id);

    int updateByPrimaryKeySelective(ProjectJob record);

    int updateByPrimaryKey(ProjectJob record);

    @ResultMap("BaseResultMap")
    @Select("select * from SC02")
    List<ProjectJob> selectList();

    int deleteAll(@Param("ids") List<String> ids);

    int deleteOne(@Param("id") String sc02Id);

    int updateStatus(@Param("query") ProjectJobQuery query);

    IPage<ProjectJob> selectPage(Page<ProjectJob> page,@Param("query") ProjectJobQuery query);

    @Select("select count(*) from SC02 where PROJECT_NO = #{code}")
    int checkCodeUnion(@Param("code") String code);

    int updateByProjectNo(ProjectJob projectJob);

    @Select("SELECT COUNT(*) from SC02")
    int selectCount();

    ProjectJob selectDetail(@Param("sc02Id") String sc02Id);
}
