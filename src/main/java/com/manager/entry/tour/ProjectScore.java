package com.manager.entry.tour;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 项目中内容个数及分数统计
 */
@Data
@AllArgsConstructor
public class ProjectScore {

    private String superPCheck;

    private Integer childNum;

    private Integer totalSuperScore;

    private Integer totalScore;

    private Double percent;
}
