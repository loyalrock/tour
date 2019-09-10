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

import java.util.UUID;

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
