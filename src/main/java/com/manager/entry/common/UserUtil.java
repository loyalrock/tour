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
     * 如果是全域 必须选择项目 否则报错
     * 如果是项目管理员  则返回自身
     * @param projectNo
     * @return
     */
    public static String getProjectNo (String projectNo) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String role = user.getUserRole().getUserRoleId();
        // 全域管理员登录没有项目
        UserProject userProject = user.getUserProject();
        if (userProject != null && !role.equals(Role.SYSTEM)) {
            return userProject.getProjectNo();
        } else {
            if (projectNo == null || "".equals(projectNo.trim())) {
                throw new CommonException(Message.ERROR_PROJECT);
            } else {
                return projectNo;
            }
        }
    }

    /**
     * 新增时检测时间
     * @param commonTime
     */
    public static void checkInsertTime (CommonTime commonTime) {
        Date today = new Date();
        Date enableTime = commonTime.getEnableTime();
        Date disAbleTime = commonTime.getDeactiTime();
        // 默认为今天
        if (enableTime == null) {
            enableTime = today;
            commonTime.setEnableTime(enableTime);
        } else {
            // 不为空  和 disable比较
            if (disAbleTime != null) {
                // 判断停用时间 不能早于启用时间
                if (disAbleTime.before(enableTime) || disAbleTime.before(today)) {
                    throw new CommonException(Message.SUPER_CONTENT_DEACTI_ERROR);
                }
            } else {
                // 为空不管
            }
        }
        if (disAbleTime != null) {
            if (disAbleTime.before(today)) {
                throw new CommonException(Message.SUPER_CONTENT_DEACTI_ERROR);
            }
        }

    }

    /**
     * 修改时检测启用时间和停用时间
     * @param commonTime
     * @return
     */
    public static String checkUpdateTime (CommonTime commonTime) {
        Date today = new Date();
        Date disAbleTime = commonTime.getDeactiTime();
        // 停用时间不为空  如果在于今天 则停用 如果晚于今天 启用并修改启用时间
        if (disAbleTime != null) {
            if (disAbleTime.before(today)) {
                return User.DISABLE;
            } else {
                commonTime.setEnableTime(today);
                return User.ENABLE;
            }
        } else {
            return User.ENABLE;
        }
    }
}
