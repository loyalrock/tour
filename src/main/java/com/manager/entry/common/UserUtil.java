package com.manager.entry.common;

import com.manager.entry.system.User;
import com.manager.entry.system.UserProject;
import com.manager.util.Delete;
import com.manager.util.Message;
import com.manager.util.Role;
import org.apache.shiro.SecurityUtils;

import java.util.Date;

/**
 * 一些方法
 */
public class UserUtil {

    public static CommonEntry insertData(CommonEntry commonEntry) {

        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        Date now = new Date();

        commonEntry.setCreateTime(now);
        commonEntry.setCreateUser(currentUser.getSs01Id());
        commonEntry.setStatus(commonEntry.getStatus() == null || "".equals(commonEntry.getStatus().trim()) ? User.ENABLE : commonEntry.getStatus());
        commonEntry.setDeleteFlag(commonEntry.getDeleteFlag() == null || "".equals(commonEntry.getDeleteFlag().trim()) ? Delete.UN_DELETE : commonEntry.getDeleteFlag());

        return commonEntry;
    }

    public static CommonEntry updateData(CommonEntry commonEntry) {

        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        Date now = new Date();

        commonEntry.setUpdateTime(now);
        commonEntry.setUpdateUser(currentUser.getSs01Id());

        return commonEntry;
    }

    /**
     * 返回自身关联的项目
     * @param projectNo
     * @return
     */
    public static String getProjectNo (String projectNo) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        UserProject userProject = user.getUserProject();
        if (userProject != null) {
            return userProject.getProjectNo();
        } else {
            String role = user.getUserRole().getUserRoleId();
            if (!role.equals(Role.SYSTEM)) {
                throw new CommonException(Message.LOGIN_TYPE_ERROR);
            } else {
                return projectNo;
            }
        }
    }
}
