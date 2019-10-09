package com.manager.entry.tour;

import lombok.Data;

import java.util.List;

/**
 * 首页折线图
 */
@Data
public class ProjectDocumentNum {

    private String superPCheck;

    private List<YearAndNumber> yearAndNumbers;
}
