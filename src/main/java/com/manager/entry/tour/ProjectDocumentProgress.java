package com.manager.entry.tour;

import lombok.Data;

/**
 * 首页文件自评进度
 */
@Data
public class ProjectDocumentProgress {

    private Integer total;

    private Integer finish;

    private Double percent;
}
