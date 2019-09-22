package com.manager.entry.system;

import com.manager.entry.common.CommonEntry;
import com.manager.util.group.UpdateGroup;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class Role extends CommonEntry {

    @NotBlank(message = "缺失主键", groups = {UpdateGroup.class})
    private String ss02Id;

    private String userRoleId;

    private String userRoleName;

    private String remarks;

    public Role(String ss02Id, String userRoleId, String userRoleName, String remarks, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.ss02Id = ss02Id;
        this.userRoleId = userRoleId;
        this.userRoleName = userRoleName;
        this.remarks = remarks;
    }

    public Role() {
        super();
    }

}
