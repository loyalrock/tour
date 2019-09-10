package com.manager.tour.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.tour.SuperContent;
import com.manager.entry.tour.SuperContentQuery;

public interface SuperContentService {

    /**
     * 分页
     * @param page
     * @param query
     * @return
     */
    IPage<SuperContent> selectPage(Page<SuperContent> page, SuperContentQuery query);

    SuperContent selectDetail(String id);

    int add(SuperContent superContent);

    int update(SuperContent superContent);

}
