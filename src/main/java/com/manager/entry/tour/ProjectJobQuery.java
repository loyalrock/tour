package com.manager.entry.tour;

import java.util.List;

/**
 * 描述
 *
 * @auth0r nosign
 * @date 2019/09/12
 */
public class ProjectJobQuery {
    
    private List<String> ids;

    private String id;

    private String projectName;

    private String status;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
