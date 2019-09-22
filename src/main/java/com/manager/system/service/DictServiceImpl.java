package com.manager.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.UserUtil;
import com.manager.entry.system.Category;
import com.manager.entry.system.CategoryDict;
import com.manager.entry.system.Dict;
import com.manager.entry.system.DictQuery;
import com.manager.system.dao.CategoryDictMapper;
import com.manager.system.dao.CategoryMapper;
import com.manager.system.dao.DictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 数据字典 service Impl
 */
@Service
public class DictServiceImpl implements DictService{

    private String initDirId = "DIR00001";

    @Autowired
    private DictMapper dictMapper;

    @Autowired
    private CategoryDictMapper categoryDictMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public IPage<Dict> selectPage(Page<Dict> page, DictQuery query) throws Exception {
        return dictMapper.selectPage(page, query);
    }

    @Override
    public int addDict(Dict dict) throws Exception {

        String dictId = getNextId();
        dict.setDirId(dictId);
        UserUtil.insertData(dict);
        dict.setSs03Id(UUID.randomUUID().toString());
        int count = dictMapper.insertSelective(dict);
        return count;
    }


    /**
     * 获取下一个dirId
     * @param dirId
     * @return
     */
    private String getNextDirId(String dirId) {
        if (dirId != null) {
            int id = Integer.parseInt(dirId.replace("DIR", ""));
            id ++;
            String idStr = String.valueOf(id);
            return initDirId.substring(0, initDirId.length() - idStr.length()) + idStr;
        } else {
            return initDirId;
        }
    }

    @Override
    public int updateDict(Dict dict) throws Exception {
//        没有类别修改
//        // 删除原有的
//        categoryDictMapper.deleteByDictUid(dict.getSs03Id());

//        // 批量新增
//        List<String> categoryUids = dict.getCategoryUids();
//        List<CategoryDict> categoryDicts = new ArrayList<>();
//        for(String categoryUid : categoryUids) {
//            CategoryDict categoryDict = new CategoryDict(dict.getSs03Id(), categoryUid);
//            categoryDicts.add(categoryDict);
//        }
//        categoryDictMapper.insertList(categoryDicts);

        // 获取修改时间 人
        UserUtil.updateData(dict);
        Dict updateData = new Dict();
        updateData.setSs03Id(dict.getSs03Id());
        updateData.setDirName(dict.getDirName());
        // 修改数据字典其他参数
        int count = dictMapper.updateByPrimaryKeySelective(updateData);

        return count;
    }

    @Override
    public int updateStatus(Dict dict) throws Exception {
        UserUtil.updateData(dict);
        int count = dictMapper.updateByPrimaryKeySelective(dict);
        return count;
    }

    @Override
    public int deleteDict(String dictUid) throws Exception {
        return dictMapper.deleteByPrimaryKey(dictUid);
    }

    @Override
    public String getNextId() throws Exception {
        // 查询最后一个 获取编号 累加
        // 第三个参数 不查询总数
        Page<Dict> page = new Page<>(1,1, false);
        List<OrderItem> orderItems = new ArrayList<>();
        // 编号降序
        orderItems.add(OrderItem.desc("DIR_ID"));
        page.setOrders(orderItems);
        IPage<Dict> dictIPage = dictMapper.selectPage(page, null);

        String nextId;
        if (dictIPage.getRecords().size() > 0) {
            Dict lastDict = dictIPage.getRecords().get(0);
            nextId = getNextDirId(lastDict.getDirId());
        } else {
            // 新增第一个
            nextId = getNextDirId(null);
        }

        return nextId;
    }

    @Override
    public List<Category> selectCategoryList(String classify) {
        return categoryMapper.selectByClassify(classify);
    }

    @Override
    public Dict selectDetail(String dictUid) {
        return dictMapper.selectDetail(dictUid);
    }


}
