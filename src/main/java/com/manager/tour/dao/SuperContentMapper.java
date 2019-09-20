package com.manager.tour.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.tour.SuperContent;
import com.manager.entry.tour.SuperContentQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SuperContentMapper {
    int deleteByPrimaryKey(String sc01Id);

    int insert(SuperContent record);

    int insertSelective(SuperContent record);

    SuperContent selectByPrimaryKey(String sc01Id);

    int updateByPrimaryKeySelective(SuperContent record);

    int updateByPrimaryKey(SuperContent record);

    /**
     * 扉页查询
     * @param page
     * @param query
     * @return
     */
    IPage<SuperContent> selectPage(Page<SuperContent> page, @Param("query") SuperContentQuery query);

    String selectNextCode(@Param("level") String level, @Param("code") String code);

    List<SuperContent> selectLevel(@Param("level") String level, @Param("code") String code);

    int insertAll(@Param("query") List<Object> list);

    /**
     * 批量启用或者停用内容 并修改启用和停用时间
     * @param ids
     * @param status
     * @return
     */
    int updateAllStatus(@Param("ids") List<String> ids, String status);

    List<SuperContent> selectAll(@Param("query") SuperContentQuery query);

    @Select("select SC01_ID, SUPER_P_SCORE from SC01 where SUPER_P_NO = #{code}")
    @ResultMap("BaseResultMap")
    SuperContent selectByCode(@Param("code") String code);
}
