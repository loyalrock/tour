package com.manager.tour.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.ResultEntry;
import com.manager.entry.tour.SuperContent;
import com.manager.entry.tour.SuperContentQuery;
import com.manager.tour.service.SuperContentService;
import com.manager.util.*;
import com.manager.util.group.InsertGroup;
import com.manager.util.group.UpdateGroup;
import com.manager.util.group.UpdateStatusGroup;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/content")
public class SuperContentController {

    @Autowired
    private SuperContentService superContentService;

    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry selectPage(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        // 文件
        superContentService.importFile(file, response);
        return ResultUtil.success(Message.SELECT_SUCCESS);
    }

    /**
     * 分页查询
     * @param page
     * @param query
     * @return
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
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
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT}, logical = Logical.OR)
    public ResultEntry selectDetail(@RequestParam("superContentUid") @NotBlank(message = "缺失主键") String superContentUid) {
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
    @RequestMapping(value = "/update/index", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry update(@Validated(value = {UpdateGroup.class}) @RequestBody SuperContent superContent) {
        int count = superContentService.update(superContent);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 下一个code 默认同级
     * @param level
     * @param code
     * @return
     */
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry selectNextCode(@RequestParam(value = "level", required = false, defaultValue = "0") Integer level,
                                      @RequestParam(value = "code", required = false) String code) {
        SuperContent superContent = superContentService.getNextCode(level, code);
        return ResultUtil.success(Message.SELECT_SUCCESS, superContent);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM, Role.EXPERTS}, logical = Logical.OR)
    public ResultEntry selectByLevel (@RequestParam(defaultValue = "1", value = "level") String level,
                                      @RequestParam(value = "code", required = false) String code) {
        List<SuperContent> superContents = superContentService.selectLevel(level, code);
        return ResultUtil.success(Message.SELECT_SUCCESS, superContents);
    }

    @RequestMapping(value = "/status/update/all", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry updateAllStatus (@Validated(value = {UpdateStatusGroup.class}) @RequestBody SuperContent superContent) {
        int count = superContentService.updateAllStatus(superContent.getSc01Ids(), superContent.getStatus());
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 查询所有
     * @param query
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM, Role.PROJECT, Role.EXPERTS}, logical = Logical.OR)
    public ResultEntry selectAll (SuperContentQuery query) {
        List<SuperContent> superContents = superContentService.selectAll(query);
        return ResultUtil.success(Message.SELECT_SUCCESS, superContents);
    }

}
