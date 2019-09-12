package com.manager.tour.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.ResultEntry;
import com.manager.entry.tour.SuperContent;
import com.manager.entry.tour.SuperContentQuery;
import com.manager.tour.service.SuperContentService;
import com.manager.util.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

@RestController
@RequestMapping("/content")
public class SuperContentController {

    @Autowired
    private SuperContentService superContentService;

    /**
     * 分页查询
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT})
    public ResultEntry selectPage(Page page, SuperContentQuery query) {
        IPage<SuperContent> superContentIPage = superContentService.selectPage(page, query);
        return ResultUtil.success(Message.SELECT_SUCCESS, superContentIPage);
    }

    /**
     * 分页查询
     * @param superContentUid
     * @return
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT})
    public ResultEntry selectDetail(@RequestParam("superContentUid") String superContentUid) {
        SuperContent superContent = superContentService.selectDetail(superContentUid);
        return ResultUtil.success(Message.SELECT_SUCCESS, superContent);
    }

    /**
     * 新增
     * @param superContent
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry add(@Validated(value = {InsertGroup.class}) @RequestBody SuperContent superContent) {
        int count = superContentService.add(superContent);
        return ResultUtil.success(Message.INSERT_SUCCESS);
    }

    /**
     * 新增
     * @param superContent
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry update(@Validated(value = {UpdateGroup.class}) @RequestBody SuperContent superContent) {
        int count = superContentService.update(superContent);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 下一个code
     * @param level
     * @param code
     * @return
     */
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry selectNextCode(@RequestParam(value = "level", required = false) Integer level,
                                      @RequestParam(value = "code", required = false) String code) {
        SuperContent superContent = superContentService.getNextCode(level, code);
        return ResultUtil.success(Message.SELECT_SUCCESS, superContent);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry selectByLevel (@RequestParam(defaultValue = "1", value = "level") String level,
                                      @RequestParam(value = "code", required = false) String code) {
        List<SuperContent> superContents = superContentService.selectLevel(level, code);
        return ResultUtil.success(Message.SELECT_SUCCESS, superContents);
    }

}
