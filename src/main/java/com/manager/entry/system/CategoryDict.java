package com.manager.entry.system;

public class CategoryDict {
    private String ss04Id;

    private String ss05Id;

    public CategoryDict(String ss04Id, String ss05Id) {
        this.ss04Id = ss04Id;
        this.ss05Id = ss05Id;
    }

    public CategoryDict() {
        super();
    }

    public String getSs04Id() {
        return ss04Id;
    }

    public void setSs04Id(String ss04Id) {
        this.ss04Id = ss04Id == null ? null : ss04Id.trim();
    }

    public String getSs05Id() {
        return ss05Id;
    }

    public void setSs05Id(String ss05Id) {
        this.ss05Id = ss05Id == null ? null : ss05Id.trim();
    }
}