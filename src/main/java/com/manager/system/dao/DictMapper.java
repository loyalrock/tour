package com.manager.system.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.system.Dict;
import com.manager.entry.system.DictQuery;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DictMapper {
    int deleteByPrimaryKey(String ss03Id);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(String ss03Id);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

    /**
     * 分页查询
     * @param page
     * @param query
     * @return
     */
    IPage<Dict> selectPage(Page<Dict> page, @Param("query")DictQuery query);

    Dict selectDetail(@Param("dictUid") String dictUid);

}
