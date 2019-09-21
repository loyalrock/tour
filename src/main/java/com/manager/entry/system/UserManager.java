package com.manager.entry.system;

import com.manager.util.group.InsertGroup;
import com.manager.util.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 用户管理查询实体类
 * @author zhongyan
 */
@Data
public class UserManager {

    /**
     * 用户主键
     */
    @NotBlank(message = "唯一键必须", groups = {UpdateGroup.class})
    private String ss01Id;

    @NotBlank(message = "登录名未填写", groups = {UpdateGroup.class})
    private String userId;

    @NotBlank(message = "用户名称未填写", groups = {UpdateGroup.class, InsertGroup.class})
    private String userName;

    private String status;

    @NotBlank(message = "角色未选择", groups = {UpdateGroup.class, InsertGroup.class})
    private String userRoleId;

    private String userRoleName;

    /**
     * 单角色
     */
    private UserRole userRole;

//    @NotBlank(message = "所属单位未填写", groups = {UpdateGroup.class, InsertGroup.class})
    private String opUnit;

//    @NotBlank(message = "所属项目未选择", groups = {UpdateGroup.class, InsertGroup.class})
    private String projectNo;

    private String projectName;

    private String projectNameJ;

}
