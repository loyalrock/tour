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
public class ProjectJobServiceImpl implements ProjectJobService {

    @Value("${project.upload.folderName}")
    private String folderName;

    @Autowired
    private ProjectJobMapper projectJobMapper;

    @Autowired
    private DocumentShowMapper documentShowMapper;

    @Autowired
    private ImageShowMapper imageShowMapper;

    @Autowired
    private LineShowMapper lineShowMapper;

    @Autowired
    private UploadDataFileMapper uploadDataFileMapper;

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

        count = projectJobMapper.insertSelective(projectJob);

        return count;
    }

    @Override
    public ProjectJob selectDetail(String sc02Id) {
        return projectJobMapper.selectDetail(sc02Id);
    }

    @Override
    public int uploadFile(MultipartFile file, String projectNo, String type) throws Exception {
        String filePath = saveFile(file);
        ProjectJob projectJob = new ProjectJob();
        projectJob.setProjectNo(projectNo);
        UserUtil.updateData(projectJob);
        if (FileType.INDEX_PIC.equals(type)) {

            projectJob.setIndexPic(Flag.HAVE);
            UploadDataFile uploadDataFile = new UploadDataFile();
            // 新增数据
            UserUtil.insertData(uploadDataFile);

            uploadDataFile.setSfj01Id(UUID.randomUUID().toString());
            uploadDataFile.setAppSource(projectNo);
            uploadDataFile.setAppUrl(filePath);
            uploadDataFile.setAppName(file.getOriginalFilename());
            int num = uploadDataFileMapper.selectCount(projectNo);
            uploadDataFile.setAppNum(String.valueOf(num + 1));
            uploadDataFileMapper.insertSelective(uploadDataFile);

        } else if (FileType.SHOW_PIC.equals(type)) {
            projectJob.setIfPic(Flag.HAVE);
            ImageShow imageShow = new ImageShow();
            // 新增数据
            UserUtil.insertData(imageShow);

            imageShow.setSc0202Id(UUID.randomUUID().toString());
            imageShow.setPicSource(projectNo);
            imageShow.setAppUrl(filePath);
            imageShow.setPicName(file.getOriginalFilename());
            int num = imageShowMapper.selectCount(projectNo);
            imageShow.setPicNum(String.valueOf(num + 1));
            imageShowMapper.insertSelective(imageShow);
            projectJob.setIfPic(Flag.HAVE);
        } else if (FileType.SHOW_FILE.equals(type)) {
            projectJob.setIfFile(Flag.HAVE);
            DocumentShow documentShow = new DocumentShow();
            // 新增数据
            UserUtil.insertData(documentShow);

            documentShow.setSc0201Id(UUID.randomUUID().toString());
            documentShow.setFileSource(projectNo);
            documentShow.setFileUrl(filePath);
            documentShow.setFileName(file.getOriginalFilename());
            int num = documentShowMapper.selectCount(projectNo);
            documentShow.setFileNum(String.valueOf(num + 1));
            documentShowMapper.insertSelective(documentShow);
            projectJob.setIfPic(Flag.HAVE);
        }

        int count = projectJobMapper.updateByProjectNo(projectJob);
        return count;
    }

    public String saveFile(MultipartFile file) throws Exception {

        FileOutputStream out = null;
        InputStream in = null;
        String filePath;
        // 检测文件大小
        if (file.isEmpty()) {
            throw new CommonException(Message.FILE_IS_EMPTY);
        }

        try {
            // 检测文件目录是否存在
            String systemPath = System.getProperty("user.dir");
            File folder = new File(systemPath + "/files");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            // 获取前缀
            String Suffix;
            String fileName = file.getOriginalFilename();
            Suffix = fileName.substring(fileName.indexOf("."));
            // 文件路径
            filePath = systemPath + "/files/" + UUID.randomUUID().toString() + Suffix;
            out = new FileOutputStream(filePath);
            in = file.getInputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
                out.flush();
            }
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new CommonException(Message.FILE_SAVE_FAILED);
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
        return filePath;
    }

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
