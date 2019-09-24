package com.manager.tour.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manager.entry.common.CommonException;
import com.manager.entry.common.UserUtil;
import com.manager.entry.system.User;
import com.manager.entry.tour.*;
import com.manager.shiro.ShiroRealm;
import com.manager.tour.dao.*;
import com.manager.util.Flag;
import com.manager.util.Message;
import com.manager.util.Role;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private DocumentShowMapper documentShowMapper;

    @Autowired
    private ImageShowMapper imageShowMapper;

    @Autowired
    private LineShowMapper lineShowMapper;

    @Autowired
    private RegionShowMapper regionShowMapper;

    @Override
    public List<String> selectIndexPics(String code) {
        return projectJobMapper.selectIndexPics(code);
    }

    @Override
    public int checkProjectNameShort(String code) {
        return projectJobMapper.checkProjectJobShort(code);
    }

    @Override
    public List<ProjectJob> selectList() {
        return projectJobMapper.selectList();
    }

    @Override
    public int add(ProjectJob projectJob) {

        UserUtil.insertData(projectJob);
        projectJob.setSc02Id(UUID.randomUUID().toString());

        // 校验开始和停用时间
        UserUtil.checkInsertTime(projectJob);

        // 检测编号唯一
        int count = projectJobMapper.checkCodeUnion(projectJob.getProjectNo());

        if (count > 0) {
            throw new CommonException(Message.CODE_UN_UNIQUE);
        }

        // 项目简称
        count  = projectJobMapper.checkProjectJobShort(projectJob.getProjectNameJ());
        if (count > 0) {
            throw new CommonException(Message.PROJECT_NAME_J_UNIQUE);
        }

        int currentNo = uploadDataFileMapper.selectCount(projectJob.getProjectNo());
        List<UploadDataFile> uploadDataFiles = projectJob.getUploadDataFiles();
        if (uploadDataFiles != null && uploadDataFiles.size() > 0) {
            for (UploadDataFile uploadDataFile : uploadDataFiles) {
                uploadDataFile.setSfj01Id(UUID.randomUUID().toString());
                uploadDataFile.setAppSource(projectJob.getProjectNo());
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
                UserUtil.checkParentNo(projectContent);
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

    @Override
    public int update(ProjectJob projectJob) {

        /**
         * 校验启用和停用时间
         */
        String status = UserUtil.checkUpdateTime(projectJob);
        projectJob.setStatus(status);

        User user = (User) SecurityUtils.getSubject().getPrincipal();
        // 当前操作账户
        String ss01Id = user.getSs01Id();

        // 修改删除新增替换的首页图片
        List<UploadDataFile> insertUploadList = new ArrayList<>();
        List<String> deleteUploadNotInIds = new ArrayList<>();

        List<UploadDataFile> uploadDataFiles = projectJob.getUploadDataFiles();
        if (uploadDataFiles != null && uploadDataFiles.size() > 0) {
            projectJob.setIndexPic(Flag.HAVE);
            for (UploadDataFile uploadDataFile : uploadDataFiles) {
                if (uploadDataFile.getSfj01Id() == null) {
                    UserUtil.insertData(uploadDataFile);
                    uploadDataFile.setSfj01Id(UUID.randomUUID().toString());
                    uploadDataFile.setAppSource(projectJob.getProjectNo());
                    insertUploadList.add(uploadDataFile);
                } else {
                    deleteUploadNotInIds.add(uploadDataFile.getSfj01Id());
                    UserUtil.updateData(uploadDataFile);
                    uploadDataFileMapper.updateByPrimaryKeySelective(uploadDataFile);
                }
            }
        } else {
            projectJob.setIndexPic(Flag.NOT_HAVE);
        }
        // 先删除在新增 如果有id就排除法删除 没有的情况下全删 修改时 已有的数据即为全部
        uploadDataFileMapper.deleteAll(projectJob.getProjectNo(), deleteUploadNotInIds, ss01Id);
        if (insertUploadList.size() > 0) {
            uploadDataFileMapper.insertAll(insertUploadList);
        }

        // 修改删除新增替换的维护内容
        List<ProjectContent> insertContentList = new ArrayList<>();
        List<String> deleteContentNotInIds = new ArrayList<>();

        List<ProjectContent> projectContents = projectJob.getProjectContents();
        if (projectContents != null && projectContents.size() > 0) {
            for (ProjectContent projectContent : projectContents) {
                if (projectContent.getSc0201Id() == null) {
                    UserUtil.insertData(projectContent);
                    projectContent.setSc0201Id(UUID.randomUUID().toString());
                    projectContent.setProjectNo(projectJob.getProjectNo());
                    insertContentList.add(projectContent);
                } else {
                    deleteContentNotInIds.add(projectContent.getSc0201Id());
                    UserUtil.updateData(projectContent);
                    projectContentMapper.updateByPrimaryKeySelective(projectContent);
                }
            }
        }

        // 删除数量
        int count = projectContentMapper.deleteAll(projectJob.getProjectNo(), deleteContentNotInIds, ss01Id);
        if (count > 0) {
            // 数量大于0 有被删除的 查询删除的ID
            List<String> deleteIds = projectContentMapper.selectDeleteId(projectJob.getProjectNo(), deleteContentNotInIds);
            if (deleteIds != null && deleteIds.size() > 0) {
                // 删除内容关联的图片路线等 sc0201Ids
                documentShowMapper.deleteAllByContent(deleteIds, ss01Id);
                imageShowMapper.deleteAllByContent(deleteIds, ss01Id);
                lineShowMapper.deleteAllByContent(deleteIds, ss01Id);
                regionShowMapper.deleteAllByContent(deleteIds, ss01Id);
            }
        }
        if (insertContentList.size() > 0) {
            projectContentMapper.insertAll(insertContentList);
        }

        UserUtil.updateData(projectJob);
        // 不更新这两个
        projectJob.setProjectNo(null);
        projectJob.setProjectNameJ(null);
        count = projectJobMapper.updateByPrimaryKeySelective(projectJob);
        return count;
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

        User user = (User)SecurityUtils.getSubject().getPrincipal();

        String role = ShiroRealm.USER_ROLE_CACHE.get(user.getSs01Id());
        String ss01Id = null;
        // 不是全域管理员就查询所属项目 该接口只有项目管理员和全域管理员可以访问
        if (!role.equals(Role.SYSTEM)) {
            ss01Id = user.getSs01Id();
        }

        return projectJobMapper.selectPage(page, query, ss01Id);
    }
}
