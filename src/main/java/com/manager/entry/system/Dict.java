package com.manager.entry.system;

import com.manager.entry.common.CommonEntry;
import com.manager.util.InsertGroup;
import com.manager.util.UpdateGroup;
import com.manager.util.UpdateStatusGroup;
import org.apache.ibatis.annotations.Update;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class Dict extends CommonEntry {
    @NotBlank(message = "唯一键缺失", groups = {UpdateGroup.class, UpdateStatusGroup.class})
    private String ss03Id;

    @NotBlank(message = "字典ID缺失", groups = {InsertGroup.class})
    private String dirId;

    @NotBlank(message = "字典名称缺失", groups = {InsertGroup.class})
    private String dirName;

    private String dirExp;

    // 查看详情
    private List<Category> categories;

    // 新增或者修改
    @NotBlank(message = "字典说明缺失", groups = {InsertGroup.class})
    private List<String> categoryUids;

    public List<String> getCategoryUids() {
        return categoryUids;
    }

    public void setCategoryUids(List<String> categoryUids) {
        this.categoryUids = categoryUids;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Dict(String ss03Id, String dirId, String dirName, String dirExp, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.ss03Id = ss03Id;
        this.dirId = dirId;
        this.dirName = dirName;
        this.dirExp = dirExp;
    }

    public Dict() {
        super();
    }

    public String getSs03Id() {
        return ss03Id;
    }

    public void setSs03Id(String ss03Id) {
        this.ss03Id = ss03Id == null ? null : ss03Id.trim();
    }

    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId == null ? null : dirId.trim();
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName == null ? null : dirName.trim();
    }

    public String getDirExp() {
        return dirExp;
    }

    public void setDirExp(String dirExp) {
        this.dirExp = dirExp == null ? null : dirExp.trim();
    }
}
