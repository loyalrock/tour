package com.manager.tour.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.CommonException;
import com.manager.entry.common.UserUtil;
import com.manager.entry.tour.SuperContent;
import com.manager.entry.tour.SuperContentQuery;
import com.manager.tour.dao.SuperContentMapper;
import com.manager.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

@Service
@Transactional(rollbackFor = Exception.class)
public class SuperContentServiceImpl implements SuperContentService{

    @Autowired
    private SuperContentMapper superContentMapper;

    @Override
    public IPage<SuperContent> selectPage(Page<SuperContent> page, SuperContentQuery query) {
        return superContentMapper.selectPage(page, query);
    }

    @Override
    public SuperContent selectDetail(String id) {
        return superContentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(SuperContent superContent) {
        checkTime(superContent);
        superContent.setSc01Id(UUID.randomUUID().toString());
        UserUtil.insertData(superContent);
        return superContentMapper.insertSelective(superContent);
    }

    @Override
    public int update(SuperContent superContent) {
        checkTime(superContent);
        UserUtil.updateData(superContent);
        return superContentMapper.updateByPrimaryKeySelective(superContent);
    }

    @Override
    public SuperContent getNextCode(Integer level, String code) {
        SuperContent superContent = new SuperContent();
        if (code == null) {
            superContent.setSuperPNo("QJ001");
            superContent.setSuperPLevel("1");
            superContent.setSysNo("1");
        } else {
            // 计算长度 除以三 + level是否下一级
            String queryLevel = String.valueOf(code.replace("QJ", "").length() / 3 + level);
            String nextCode = superContentMapper.selectNextCode(queryLevel, level == 0 ? null : code);
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
            superContent.setSysNo(getSysNo(nextCode));
        }

        return superContent;
    }

    @Override
    public List<SuperContent> selectLevel(String level, String code) {
        return superContentMapper.selectLevel(level, code);
    }

    /**
     * 通过编号获取系统编号
     * @param code
     * @return
     */
    private String getSysNo (String code) {
        code = code.replace("QJ", "");
        StringBuffer codeBuffer = new StringBuffer(code);
        StringBuffer sysNoBuffer = new StringBuffer();
        while (codeBuffer.length() > 0) {
            sysNoBuffer.append(codeBuffer.substring(0, 3).replace("0", ""));
            sysNoBuffer.append(".");
            // 改变code
            codeBuffer = codeBuffer.delete(0, 3);
        }
        return sysNoBuffer.substring(0, sysNoBuffer.length() - 1);
    }

    /**
     * 校验时间
     * @param superContent
     */
    public void checkTime (SuperContent superContent) {
        Long start = superContent.getEnableTime().getTime();
        Long end = superContent.getDeactiTime().getTime();
        if (start > end) {
            throw new CommonException(Message.CONTENT_TIME_ERROR);
        }
    }
}
