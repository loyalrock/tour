package com.manager.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.system.Dict;
import com.manager.entry.system.DictQuery;

/**
 * 数据字典service
 */
public interface DictService {

    IPage<Dict> selectPage(Page<Dict> page, DictQuery query) throws Exception;

    int addDict(Dict dict) throws Exception;

    int updateDict(Dict dict) throws Exception;

    int updateStatus(Dict dict) throws Exception;

    int deleteDict(String dictUid) throws Exception;

    String getNextId() throws Exception;
}
