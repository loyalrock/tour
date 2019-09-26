package com.manager.tour.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.CommonException;
import com.manager.entry.common.UserUtil;
import com.manager.entry.system.User;
import com.manager.entry.tour.SuperContent;
import com.manager.entry.tour.SuperContentExcel;
import com.manager.entry.tour.SuperContentQuery;
import com.manager.tour.dao.SuperContentMapper;
import com.manager.util.Delete;
import com.manager.util.Message;
import com.manager.util.excel.ExcelUtil;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;

@Service
@Transactional(rollbackFor = Exception.class)
public class SuperContentServiceImpl implements SuperContentService {

    @Autowired
    private SuperContentMapper superContentMapper;

    @Override
    public List<SuperContent> selectAll(SuperContentQuery query) {
        return superContentMapper.selectAll(query);
    }

    @Override
    public IPage<SuperContent> selectPage(Page<SuperContent> page, SuperContentQuery query) {
        return superContentMapper.selectPage(page, query);
    }

    @Override
    public int updateAllStatus(List<String> ids, String status) {
        return superContentMapper.updateAllStatus(ids, status);
    }

    @Override
    public SuperContent selectDetail(String id) {
        return superContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(SuperContent superContent) {

        // 保证父级
        UserUtil.checkParentNo(superContent);
        SuperContent check = superContentMapper.selectByCode(superContent.getSuperPNo());
        if (check != null) {
            throw new CommonException(Message.CODE_UN_UNIQUE);
        }

        superContent.setSc01Id(UUID.randomUUID().toString());
        UserUtil.insertData(superContent);

        UserUtil.checkInsertTime(superContent);

        return superContentMapper.insertSelective(superContent);
    }

    /**
     * 修改维护内容
     *
     * @param superContent
     * @return
     */
    @Override
    public int update(SuperContent superContent) {
        UserUtil.updateData(superContent);
        String status = UserUtil.checkUpdateTime(superContent);
        superContent.setStatus(status);
        return superContentMapper.updateByPrimaryKeySelective(superContent);
    }

    @Override
    public int importFile(MultipartFile file, HttpServletResponse response) {

        List<Object> items = ExcelUtil.readExcel(file, new SuperContentExcel(), 1, 1);
        List<SuperContentExcel> errorItems = new ArrayList<>();

        boolean canInsert = true;
        int length = items != null ? items.size() : 0;

        for (int i = 0; i < length; i++) {

            StringBuffer errorBuffer = new StringBuffer();

            SuperContentExcel superContentExcel = (SuperContentExcel) items.get(i);

            if (superContentExcel.getSuperPNo() == null || "".equals(superContentExcel.getSuperPNo().trim())) {
                errorBuffer.append("内容编号缺失；");
            }
            if (superContentExcel.getSuperPLevel() == null || "".equals(superContentExcel.getSuperPLevel().trim())) {
                errorBuffer.append("内容层级缺失；");
            }
            if (superContentExcel.getSysNo() == null || "".equals(superContentExcel.getSysNo().trim())) {
                errorBuffer.append("系统序号缺失；");
            }

            if (errorBuffer.length() > 0) {
                superContentExcel.setErrorMsg(errorBuffer.toString());
            }
            errorItems.add(superContentExcel);
        }

        if (!canInsert) {
            // 不能新增 返回
            ExcelUtil.writeExcel(response, errorItems, "错误提示", "sheet-1", new SuperContentExcel());
            throw new CommonException(Message.CONTENT_IMPORT_ERROR);
        }

        return superContentMapper.insertAll(items);
    }


    @Override
    public SuperContent getNextCode(Integer level, String code) {
        SuperContent superContent = new SuperContent();
        if (Strings.isBlank(code)) {
            code = "QJ";
            level = 1;
        }
        String queryLevel = String.valueOf(code.replace("QJ", "").length() / 3 + level);

        if (Integer.parseInt(queryLevel) > 5) {
            throw new CommonException(Message.SUPER_LEVEL_MAX_5);
        }
        // 查找下一级则保持不断模糊查询 如果当前级去除后三位查询
        String nextCode = superContentMapper.selectNextCode(queryLevel, level > 0 ? code : code.substring(0, code.length() - 3));
        if (nextCode == null) {
            // 下一级开始
            nextCode = code + "000";
        }
        // 取末尾数字
        String end = String.valueOf(Integer.parseInt(nextCode.substring(nextCode.length() - 3)) + 1);
        // 替换末尾的数字
        nextCode = nextCode.substring(0, nextCode.length() - end.length()) + end;
        superContent.setSuperPLevel(queryLevel);
        superContent.setSuperPNo(nextCode);
        // 保证父级
        UserUtil.checkParentNo(superContent);
        superContent.setSysNo(getSysNo(nextCode));


        return superContent;
    }

    @Override
    public List<SuperContent> selectLevel(String level, String code) {
        return superContentMapper.selectLevel(level, code);
    }

    /**
     * 通过编号获取系统编号
     *
     * @param code
     * @return
     */
    private String getSysNo(String code) {
        code = code.replace("QJ", "");
        StringBuffer codeBuffer = new StringBuffer(code);
        StringBuffer sysNoBuffer = new StringBuffer();
        while (codeBuffer.length() > 0) {
            sysNoBuffer.append(Integer.parseInt(codeBuffer.substring(0, 3)));
            sysNoBuffer.append(".");
            // 改变code
            codeBuffer = codeBuffer.delete(0, 3);
        }
        return sysNoBuffer.substring(0, sysNoBuffer.length() - 1);
    }

}
