package com.manager.tour.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.tour.SuperContent;
import com.manager.entry.tour.SuperContentQuery;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    /**
     * 查询下一个新增的code
     * @param level 0 同级  1下级
     * @param code 当前code
     * @return
     */
    SuperContent getNextCode(Integer level, String code);

    List<SuperContent> selectLevel(String level, String code);

    int importFile(MultipartFile file, HttpServletResponse response);

    int updateAllStatus(List<String> ids, String status);

}
