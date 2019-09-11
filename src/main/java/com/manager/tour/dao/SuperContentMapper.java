package com.manager.tour.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.tour.SuperContent;
import com.manager.entry.tour.SuperContentQuery;
import org.apache.ibatis.annotations.Param;

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
}
