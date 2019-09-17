package com.manager.tour.service;

import com.manager.entry.common.UserUtil;
import com.manager.entry.system.User;
import com.manager.entry.tour.*;
import com.manager.tour.dao.*;
import com.manager.util.Delete;
import com.manager.util.Flag;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
    public int deleteDocument(String sc020101Id) {
        DocumentShow documentShow = new DocumentShow();
        UserUtil.updateData(documentShow);
        documentShow.setSc020101Id(sc020101Id);
        documentShow.setDeleteFlag(Delete.DELETE_ED);
        documentShow.setStatus(Flag.NOT_HAVE);
        return documentShowMapper.updateByPrimaryKeySelective(documentShow);
    }

    @Override
    public int deleteImage(String sc020102) {
        ImageShow imageShow = new ImageShow();
        UserUtil.updateData(imageShow);
        imageShow.setSc020102Id(sc020102);
        imageShow.setDeleteFlag(Delete.DELETE_ED);
        imageShow.setStatus(Flag.NOT_HAVE);
        return imageShowMapper.updateByPrimaryKeySelective(imageShow);
    }

    @Override
    public int deleteLine(String sc020103) {
        LineShow lineShow = new LineShow();
        UserUtil.updateData(lineShow);
        lineShow.setSc020103Id(sc020103);
        lineShow.setDeleteFlag(Delete.DELETE_ED);
        lineShow.setStatus(Flag.NOT_HAVE);
        return lineShowMapper.updateByPrimaryKeySelective(lineShow);
    }

    @Override
    public int deleteDist(String sc020104) {
        RegionShow regionShow = new RegionShow();
        UserUtil.updateData(regionShow);
        regionShow.setSc020104Id(sc020104);
        regionShow.setDeleteFlag(Delete.DELETE_ED);
        regionShow.setStatus(Flag.NOT_HAVE);
        return regionShowMapper.updateByPrimaryKeySelective(regionShow);
    }

    /**
     * 新增内容维护
     * @param projectContent
     * @return
     */
    @Override
    public int update(ProjectContent projectContent) {

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
                    deleteDocumentNotInIds.add(documentShow.getSc020101Id());
                    UserUtil.updateData(documentShow);
                    // 修改当前
                    documentShowMapper.updateByPrimaryKeySelective(documentShow);
                }
            }
            // 删除不在此内的
            if (deleteDocumentNotInIds.size() > 0) {
                documentShowMapper.deleteNotIn(deleteDocumentNotInIds, ss01Id);
            }
            // 新增
            if (insertDocumentList.size() > 0) {
                documentShowMapper.insertAll(insertDocumentList);
            }
        } else {
            // 不存在 删除所有
            projectContent.setIfFile(Flag.NOT_HAVE);
            documentShowMapper.deleteAll(sc0201Id, ss01Id);
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
                    deleteImageNotInIds.add(imageShow.getSc020102Id());
                    UserUtil.updateData(imageShow);
                    imageShowMapper.updateByPrimaryKeySelective(imageShow);
                }
            }
            if (deleteImageNotInIds.size() > 0) {
                documentShowMapper.deleteNotIn(deleteImageNotInIds, ss01Id);
            }
            if (insertImageList.size() > 0) {
                imageShowMapper.insertAll(insertImageList);
            }

        } else {
            projectContent.setIfPic(Flag.NOT_HAVE);
            imageShowMapper.deleteAll(sc0201Id, ss01Id);
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
                    deleteLineNotInIds.add(lineShow.getSc020103Id());
                    UserUtil.updateData(lineShow);
                    lineShowMapper.updateByPrimaryKeySelective(lineShow);
                }
            }
            if (deleteLineNotInIds.size() > 0) {
                lineShowMapper.deleteNotIn(deleteLineNotInIds, ss01Id);
            }
            if (insertLineList.size() > 0) {
                lineShowMapper.insertAll(insertLineList);
            }
        } else {
            projectContent.setIfLine(Flag.NOT_HAVE);
            lineShowMapper.deleteAll(sc0201Id, ss01Id);
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
                    deleteRegionNotInIds.add(regionShow.getSc020104Id());
                    UserUtil.updateData(regionShow);
                    regionShowMapper.updateByPrimaryKeySelective(regionShow);
                }
            }
            if (deleteRegionNotInIds.size() > 0) {
                regionShowMapper.deleteNotIn(deleteRegionNotInIds, ss01Id);
            }
            if (insertRegionList.size() > 0) {
                regionShowMapper.insertAll(insertRegionList);
            }
        } else {
            projectContent.setIfDist(Flag.NOT_HAVE);
            regionShowMapper.deleteAll(sc0201Id, ss01Id);
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
