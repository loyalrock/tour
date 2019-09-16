package com.manager.tour.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.CommonException;
import com.manager.entry.common.UserUtil;
import com.manager.entry.tour.*;
import com.manager.tour.dao.*;
import com.manager.util.FileType;
import com.manager.util.Flag;
import com.manager.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * project Service Impl
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProjectJobServiceImpl implements ProjectJobService {

    @Autowired
    private ProjectJobMapper projectJobMapper;

    @Autowired
    private UploadDataFileMapper uploadDataFileMapper;

    @Autowired
    private ProjectContentMapper projectContentMapper;

    @Override
    public List<ProjectJob> selectList() {
        return projectJobMapper.selectList();
    }

    @Override
    public int add(ProjectJob projectJob) {

        UserUtil.insertData(projectJob);
        projectJob.setSc02Id(UUID.randomUUID().toString());

        // 检测编号唯一
        int count = projectJobMapper.checkCodeUnion(projectJob.getProjectNo());

        if (count > 0) {
            throw new CommonException(Message.CODE_UN_UNIQUE);
        }

        int currentNo = uploadDataFileMapper.selectCount(projectJob.getProjectNo());
        List<UploadDataFile> uploadDataFiles = projectJob.getUploadDataFiles();
        if (uploadDataFiles != null && uploadDataFiles.size() > 0) {
            for (UploadDataFile uploadDataFile : uploadDataFiles) {
                uploadDataFile.setSfj01Id(UUID.randomUUID().toString());
                uploadDataFile.setAppSource(projectJob.getProjectNo());
                uploadDataFile.setAppNum(String.valueOf(++currentNo));
                UserUtil.insertData(uploadDataFile);
            }
            // 批量新增
            count = uploadDataFileMapper.insertAll(uploadDataFiles);
        }


        List<ProjectContent> projectContents = projectJob.getProjectContents();
        if (projectContents != null && projectContents.size() > 0) {
            for(ProjectContent projectContent : projectContents) {
                UserUtil.insertData(projectContent);
                projectContent.setSc0201Id(UUID.randomUUID().toString());
                projectContent.setProjectNo(projectJob.getProjectNo());
            }

            // 添加项目和内容的维护关系
            count = projectContentMapper.insertAll(projectContents);
        }

        // 添加项目
        count = projectJobMapper.insertSelective(projectJob);

        return count;
    }

    @Override
    public ProjectJob selectDetail(String sc02Id) {
        return projectJobMapper.selectDetail(sc02Id);
    }

//    @Override
//    public int uploadIndex(MultipartFile file, String projectNo) throws Exception {
//        // 保存图片
//        String filePath = Upload.saveFile(file);
//        ProjectJob projectJob = new ProjectJob();
//        projectJob.setProjectNo(projectNo);
//        UserUtil.updateData(projectJob);
//
//        // 显示首页图片
//        projectJob.setIndexPic(Flag.HAVE);
//        UploadDataFile uploadDataFile = new UploadDataFile();
//        // 新增数据
//        UserUtil.insertData(uploadDataFile);
//
//        uploadDataFile.setSfj01Id(UUID.randomUUID().toString());
//        uploadDataFile.setAppSource(projectNo);
//        uploadDataFile.setAppUrl(filePath);
//        uploadDataFile.setAppName(file.getOriginalFilename());
//        int num = uploadDataFileMapper.selectCount(projectNo);
//        uploadDataFile.setAppNum(String.valueOf(num + 1));
//        uploadDataFileMapper.insertSelective(uploadDataFile);
//
////        } else if (FileType.SHOW_PIC.equals(type)) {
////            projectJob.setIfPic(Flag.HAVE);
////            ImageShow imageShow = new ImageShow();
////            // 新增数据
////            UserUtil.insertData(imageShow);
////
////            imageShow.setSc0202Id(UUID.randomUUID().toString());
////            imageShow.setPicSource(projectNo);
////            imageShow.setAppUrl(filePath);
////            imageShow.setPicName(file.getOriginalFilename());
////            int num = imageShowMapper.selectCount(projectNo);
////            imageShow.setPicNum(String.valueOf(num + 1));
////            imageShowMapper.insertSelective(imageShow);
////            projectJob.setIfPic(Flag.HAVE);
////        } else if (FileType.SHOW_FILE.equals(type)) {
////            projectJob.setIfFile(Flag.HAVE);
////            DocumentShow documentShow = new DocumentShow();
////            // 新增数据
////            UserUtil.insertData(documentShow);
////
////            documentShow.setSc0201Id(UUID.randomUUID().toString());
////            documentShow.setFileSource(projectNo);
////            documentShow.setFileUrl(filePath);
////            documentShow.setFileName(file.getOriginalFilename());
////            int num = documentShowMapper.selectCount(projectNo);
////            documentShow.setFileNum(String.valueOf(num + 1));
////            documentShowMapper.insertSelective(documentShow);
////            projectJob.setIfPic(Flag.HAVE);
////        }
//
//        int count = projectJobMapper.updateByProjectNo(projectJob);
//        return count;
//    }

    private final static String PROJECT_NO_PREFIX = "XM";
    private int codeLength = 5;

    @Override
    public String getNextCode() {

        int count = projectJobMapper.selectCount();
        String code = String.valueOf(count + 1);
        StringBuffer stringbuffer = new StringBuffer(PROJECT_NO_PREFIX);
        for (int i = 0; i < codeLength - code.length(); i++) {
            stringbuffer.append("0");
        }
        stringbuffer.append(code);
        return stringbuffer.toString();
    }

    @Override
    public int deleteAll(List<String> ids) {
        return projectJobMapper.deleteAll(ids);
    }

    @Override
    public int deleteOne(String sc02Id) {
        return projectJobMapper.deleteOne(sc02Id);
    }

    @Override
    public int updateStatus(ProjectJobQuery query) {
        return projectJobMapper.updateStatus(query);
    }

    @Override
    public IPage<ProjectJob> selectPage(Page<ProjectJob> page, ProjectJobQuery query) {
        return projectJobMapper.selectPage(page, query);
    }
}
