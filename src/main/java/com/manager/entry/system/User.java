package com.manager.entry.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.manager.entry.common.CommonEntry;
import javafx.beans.DefaultProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * @auth zhongyan
 */
@Data
public class User extends CommonEntry {

    /**
     * 启用
     */
    public static final String ENABLE = "1";

    /**
     * 禁用
     */
    public static final String DISABLE = "0";

    private String ss01Id;

    /**
     * 登录账号
     */
    private String userId;

    /**
     * 用户姓名
     */
    @NotBlank(message = "用户名称不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    public User(String ss01Id, String userId, String userName, String password, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.ss01Id = ss01Id;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

    /**
     * 所属项目
     */
    private UserProject userProject;

    /**
     * 用户角色
     */
    private UserRole userRole;

    public User() {
        super();
    }
}
