package com.manager.tour.service;

import com.manager.entry.common.UserUtil;
import com.manager.entry.tour.*;
import com.manager.tour.dao.*;
import com.manager.util.Flag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 新增内容维护
     * @param projectContent
     * @return
     */
    @Override
    public int update(ProjectContent projectContent) {

        String sc0201Id = projectContent.getSc0201Id();

        // 新增文档
        List<DocumentShow> documentShows = projectContent.getDocumentShows();
        if (documentShows != null && documentShows.size() > 0) {
            projectContent.setIfFile(Flag.HAVE);
            int documentNum = documentShowMapper.selectCount(sc0201Id);
            for (DocumentShow documentShow : documentShows) {
                UserUtil.insertData(documentShow);
                documentShow.setSc020101Id(UUID.randomUUID().toString());
                documentShow.setFileNum(String.valueOf(++documentNum));
                documentShow.setFileSource(sc0201Id);
            }
            documentShowMapper.insertAll(documentShows);
        } else {
            projectContent.setIfFile(Flag.NOT_HAVE);
        }

        // 图片
        List<ImageShow> imageShows = projectContent.getImageShows();
        if (imageShows != null && imageShows.size() > 0) {
            projectContent.setIfPic(Flag.HAVE);
            int imageNum = imageShowMapper.selectCount(sc0201Id);
            for (ImageShow imageShow : imageShows) {
                UserUtil.insertData(imageShow);
                imageShow.setSc020102Id(UUID.randomUUID().toString());
                imageShow.setPicNum(String.valueOf(++imageNum));
                imageShow.setPicSource(sc0201Id);
            }
            imageShowMapper.insertAll(imageShows);
        } else {
            projectContent.setIfPic(Flag.NOT_HAVE);
        }

        // 新增线路
        List<LineShow> lineShows = projectContent.getLineShows();
        if (lineShows != null && lineShows.size() > 0) {
            projectContent.setIfLine(Flag.HAVE);
            int lineNum = lineShowMapper.selectCount(sc0201Id);
            for (LineShow lineShow : lineShows) {
                UserUtil.insertData(lineShow);
                lineShow.setSc020103Id(UUID.randomUUID().toString());
                lineShow.setLineNum(String.valueOf(++lineNum));
                lineShow.setLineSource(sc0201Id);
            }
            lineShowMapper.insertAll(lineShows);
        } else {
            projectContent.setIfLine(Flag.NOT_HAVE);
        }

        // 地域
        List<RegionShow> regionShows = projectContent.getRegionShows();
        if (regionShows != null && regionShows.size() > 0) {
            projectContent.setIfDist(Flag.HAVE);
            int regionNum = regionShowMapper.selectCount(sc0201Id);
            for (RegionShow regionShow : regionShows) {
                UserUtil.insertData(regionShow);
                regionShow.setSc020104Id(UUID.randomUUID().toString());
                regionShow.setDistNo(String.valueOf(++regionNum));
                regionShow.setDistSource(sc0201Id);
            }
            regionShowMapper.insertAll(regionShows);
        } else {
            projectContent.setIfDist(Flag.NOT_HAVE);
        }

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
