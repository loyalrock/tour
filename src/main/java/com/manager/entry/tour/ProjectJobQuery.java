package com.manager.entry.tour;

import java.util.List;

/**
 * 描述
 *
 * @auth0r nosign
 * @date 2019/09/12
 */
public class ProjectJobQuery {

    private List<String> sc02Ids;

    private String sc02Id;

    private String projectName;

    private String status;

    public List<String> getSc02Ids() {
        return sc02Ids;
    }

    public void setSc02Ids(List<String> sc02Ids) {
        this.sc02Ids = sc02Ids;
    }

    public String getSc02Id() {
        return sc02Id;
    }

    public void setSc02Id(String sc02Id) {
        this.sc02Id = sc02Id;
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
