package com.manager.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.ResultEntry;
import com.manager.entry.system.Category;
import com.manager.entry.system.Dict;
import com.manager.entry.system.DictQuery;
import com.manager.system.service.DictService;
import com.manager.util.*;
import com.manager.util.group.InsertGroup;
import com.manager.util.group.UpdateGroup;
import com.manager.util.group.UpdateStatusGroup;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 数据字典
 */
@RequestMapping("/dict")
@RestController
public class DictController {

    @Autowired
    private DictService dictService;

    /**
     * 新增
     * @param dict
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry addDict(@Validated(InsertGroup.class) @RequestBody Dict dict) throws Exception {
        int count = dictService.addDict(dict);
        return ResultUtil.success(Message.INSERT_SUCCESS);
    }

    /**
     * 修改
     * @param dict
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry updateDict(@Validated(UpdateGroup.class) @RequestBody Dict dict) throws Exception {
        int count = dictService.updateDict(dict);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 状态修改
     * @param dict
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/status/update", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry updateDictStatus(@Validated(UpdateStatusGroup.class) @RequestBody Dict dict) throws Exception {
        int count = dictService.updateStatus(dict);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 删除
     * @param dictUid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry deleteDict(@RequestParam("ss03Id") String dictUid) throws Exception {
        int count = dictService.deleteDict(dictUid);
        return ResultUtil.success(Message.UPDATE_SUCCESS);
    }

    /**
     * 分页查询
     * @param page
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry selectPage(Page page, DictQuery query) throws Exception{
        IPage<Dict> dictIPage = dictService.selectPage(page, query);
        return ResultUtil.success(Message.SELECT_SUCCESS, dictIPage);
    }

    /**
     * 详情
     * @param dictUid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry selectPage(@RequestParam("dictUid") String dictUid) throws Exception{
        Dict dict = dictService.selectDetail(dictUid);
        return ResultUtil.success(Message.SELECT_SUCCESS, dict);
    }

    /**
     * 查询下一个新增的字典id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/nextId", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry selectNextId() throws Exception {
        String nextId = dictService.getNextId();
        return ResultUtil.success(Message.SELECT_SUCCESS, nextId);
    }

    /**
     * 查询分类
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/category/list", method = RequestMethod.GET)
    @RequiresRoles(value = {Role.SYSTEM})
    public ResultEntry selectCategoryList(@RequestParam("classify") @NotBlank(message = "缺失(dir_exp)") String classify) throws Exception {
        List<Category> categories = dictService.selectCategoryList(classify);
        return ResultUtil.success(Message.SELECT_SUCCESS, categories);
    }



 }
