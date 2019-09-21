package com.manager.entry.tour;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDocumentNum {

    private String superPCheck;

    private List<YearAndNumber> yearAndNumbers;
}
