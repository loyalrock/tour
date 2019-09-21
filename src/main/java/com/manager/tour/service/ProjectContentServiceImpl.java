package com.manager.tour.service;

import com.manager.entry.common.CommonEntry;
import com.manager.entry.common.CommonException;
import com.manager.entry.common.UserUtil;
import com.manager.entry.system.User;
import com.manager.entry.tour.*;
import com.manager.tour.dao.*;
import com.manager.util.Flag;
import com.manager.util.Message;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * impl
 */
@Service
public class ProjectContentServiceImpl implements ProjectContentService {

    @Autowired
    private DocumentShowMapper documentShowMapper;

    @Autowired
    private ImageShowMapper imageShowMapper;

    @Autowired
    private LineShowMapper lineShowMapper;

    @Autowired
    private RegionShowMapper regionShowMapper;

    @Autowired
    private ProjectContentMapper projectContentMapper;

    @Override
    public List<ProjectContent> selectProjectContentLevel(String projectNo, String code, String level) {
        projectNo = UserUtil.getProjectNo(projectNo);
        return projectContentMapper.selectProjectContentLevel(projectNo, code, level);
    }

    @Override
    public int updateScore(String sc0201Id, Integer score) {

        ProjectContent projectContent = projectContentMapper.selectDetail(sc0201Id);

        Integer projectScore = projectContent.getSuperPScore();

        if (score > projectScore) {
            throw new CommonException(Message.SCORE_OVER_MAX);
        }

        ProjectContent updateData = new ProjectContent();
        updateData.setSc0201Id(sc0201Id);
        updateData.setScore(score);
        UserUtil.updateData(updateData);
        int count = projectContentMapper.updateByPrimaryKeySelective(updateData);

        return count;
    }

    /**
     * 新增内容维护
     * @param projectContent
     * @return
     */
    @Override
    public int update(ProjectContent projectContent) {

        // 查询修改前的状态
        ProjectContent oldProjectContent = projectContentMapper.selectDetail(projectContent.getSc0201Id());
        // 状态为0 不可维护
        if (!Flag.HAVE.equals(oldProjectContent.getProjectStatus())) {
            throw new CommonException(Message.PROJECT_IS_DISABLE);
        }

        // 检测修改的原始数据
        Map<String, CommonEntry> repeatMap = new HashMap<>();
        for (DocumentShow documentShow : oldProjectContent.getDocumentShows()) {
            repeatMap.put(documentShow.getSc020101Id(), documentShow);
        }
        for (ImageShow imageShow : oldProjectContent.getImageShows()) {
            repeatMap.put(imageShow.getSc020102Id(), imageShow);
        }
        for (LineShow lineShow : oldProjectContent.getLineShows()) {
            repeatMap.put(lineShow.getSc020103Id(), lineShow);
        }
        for (RegionShow regionShow : oldProjectContent.getRegionShows()) {
            repeatMap.put(regionShow.getSc020104Id(), regionShow);
        }

        // 维护内容主键
        String sc0201Id = projectContent.getSc0201Id();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        // 当前操作账户
        String ss01Id = user.getSs01Id();

        List<DocumentShow> insertDocumentList = new ArrayList<>();
        List<String> deleteDocumentNotInIds = new ArrayList<>();
        // 新增文档
        List<DocumentShow> documentShows = projectContent.getDocumentShows();
        if (documentShows != null && documentShows.size() > 0) {
            // 存在文件
            projectContent.setIfFile(Flag.HAVE);
            for (DocumentShow documentShow : documentShows) {
                if (documentShow.getSc020101Id() == null) {
                    // 创建新对象
                    UserUtil.insertData(documentShow);
                    documentShow.setSc020101Id(UUID.randomUUID().toString());
                    documentShow.setFileSource(sc0201Id);
                    insertDocumentList.add(documentShow);
                } else {
                    String sc020101Id = documentShow.getSc020101Id();
                    deleteDocumentNotInIds.add(sc020101Id);
                    // @data注解重写equals方法 比较每一个属性的值
                    if (!documentShow.equals(repeatMap.get(sc020101Id))) {
                        UserUtil.updateData(documentShow);
                        // 修改当前
                        documentShowMapper.updateByPrimaryKeySelective(documentShow);
                    }
                }
            }
        } else {
            projectContent.setIfFile(Flag.NOT_HAVE);
        }

        documentShowMapper.deleteAll(sc0201Id, deleteDocumentNotInIds, ss01Id);
        // 新增
        if (insertDocumentList.size() > 0) {
            documentShowMapper.insertAll(insertDocumentList);
        }

        // 下面以此类推
        List<ImageShow> insertImageList = new ArrayList<>();
        List<String> deleteImageNotInIds = new ArrayList<>();
        // 图片
        List<ImageShow> imageShows = projectContent.getImageShows();
        if (imageShows != null && imageShows.size() > 0) {
            projectContent.setIfPic(Flag.HAVE);
            for (ImageShow imageShow : imageShows) {
                if (imageShow.getSc020102Id() == null) {
                    UserUtil.insertData(imageShow);
                    imageShow.setSc020102Id(UUID.randomUUID().toString());
                    imageShow.setPicSource(sc0201Id);
                    insertImageList.add(imageShow);
                } else {
                    String sc020102Id = imageShow.getSc020102Id();
                    deleteImageNotInIds.add(sc020102Id);
                    if (!imageShow.equals(repeatMap.get(sc020102Id))) {
                        UserUtil.updateData(imageShow);
                        imageShowMapper.updateByPrimaryKeySelective(imageShow);
                    }
                }
            }
        } else {
            projectContent.setIfPic(Flag.NOT_HAVE);
        }

        imageShowMapper.deleteAll(sc0201Id, deleteImageNotInIds, ss01Id);
        if (insertImageList.size() > 0) {
            imageShowMapper.insertAll(insertImageList);
        }

        // 下面以此类推
        List<LineShow> insertLineList = new ArrayList<>();
        List<String> deleteLineNotInIds = new ArrayList<>();
        // 新增线路
        List<LineShow> lineShows = projectContent.getLineShows();
        if (lineShows != null && lineShows.size() > 0) {
            projectContent.setIfLine(Flag.HAVE);
            for (LineShow lineShow : lineShows) {
                if (lineShow.getSc020103Id() == null) {
                    UserUtil.insertData(lineShow);
                    lineShow.setSc020103Id(UUID.randomUUID().toString());
                    lineShow.setLineSource(sc0201Id);
                    insertLineList.add(lineShow);
                } else {
                    String sc020103Id = lineShow.getSc020103Id();
                    deleteLineNotInIds.add(sc020103Id);
                    if (!lineShow.equals(repeatMap.get(sc020103Id))) {
                        UserUtil.updateData(lineShow);
                        lineShowMapper.updateByPrimaryKeySelective(lineShow);
                    }
                }
            }
        } else {
            projectContent.setIfLine(Flag.NOT_HAVE);

        }

        lineShowMapper.deleteAll(sc0201Id, deleteLineNotInIds, ss01Id);
        if (insertLineList.size() > 0) {
            lineShowMapper.insertAll(insertLineList);
        }

        // 下面以此类推
        List<RegionShow> insertRegionList = new ArrayList<>();
        List<String> deleteRegionNotInIds = new ArrayList<>();
        // 地域
        List<RegionShow> regionShows = projectContent.getRegionShows();
        if (regionShows != null && regionShows.size() > 0) {
            projectContent.setIfDist(Flag.HAVE);
            for (RegionShow regionShow : regionShows) {
                if (regionShow.getSc020104Id() == null) {
                    UserUtil.insertData(regionShow);
                    regionShow.setSc020104Id(UUID.randomUUID().toString());
                    regionShow.setDistSource(sc0201Id);
                    insertRegionList.add(regionShow);
                } else {
                    String sc020104Id = regionShow.getSc020104Id();
                    deleteRegionNotInIds.add(sc020104Id);
                    if (!regionShow.equals(repeatMap.get(sc020104Id))) {
                        UserUtil.updateData(regionShow);
                        regionShowMapper.updateByPrimaryKeySelective(regionShow);
                    }
                }
            }
        } else {
            projectContent.setIfDist(Flag.NOT_HAVE);
        }

        regionShowMapper.deleteAll(sc0201Id, deleteRegionNotInIds, ss01Id);
        if (insertRegionList.size() > 0) {
            regionShowMapper.insertAll(insertRegionList);
        }

        // 修改内容维护
        UserUtil.updateData(projectContent);
        int count = projectContentMapper.updateByPrimaryKeySelective(projectContent);

        return count;
    }

    /**
     * 查看详情
     * @param sc0201Id
     * @return
     */
    @Override
    public ProjectContent selectDetail(String sc0201Id) {
        return projectContentMapper.selectDetail(sc0201Id);
    }
}
