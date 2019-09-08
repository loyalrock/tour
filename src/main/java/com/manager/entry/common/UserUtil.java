package com.manager.entry.common;

import com.manager.entry.system.User;
import com.manager.util.Delete;
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
        commonEntry.setUpdateTime(now);
        commonEntry.setUpdateUser(currentUser.getSs01Id());
        commonEntry.setStatus(User.ENABLE);
        commonEntry.setDeleteFlag(Delete.UN_DELETE);

        return commonEntry;
    }

    public static CommonEntry updateData(CommonEntry commonEntry) {

        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        Date now = new Date();

        commonEntry.setUpdateTime(now);
        commonEntry.setUpdateUser(currentUser.getSs01Id());

        return commonEntry;
    }
}
