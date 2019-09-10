package com.manager.entry.system;

import com.manager.entry.common.CommonEntry;

import java.util.Date;

public class Category extends CommonEntry {
    private String ss05Id;

    private String categoryCode;

    private String classify;

    private String categoryName;

    public Category(String ss05Id, String categoryCode, String classify, String categoryName, String status, String createUser, Date createTime, String updateUser, Date updateTime, String deleteFlag) {
        super(status, createUser, createTime, updateUser, updateTime, deleteFlag);
        this.ss05Id = ss05Id;
        this.categoryCode = categoryCode;
        this.classify = classify;
        this.categoryName = categoryName;
    }

    public Category() {
        super();
    }

    public String getSs05Id() {
        return ss05Id;
    }

    public void setSs05Id(String ss05Id) {
        this.ss05Id = ss05Id == null ? null : ss05Id.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify == null ? null : classify.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

}
