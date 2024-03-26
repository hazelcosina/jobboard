package com.ota.jobboard.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PositionDTO {

    private long id;
    private String name;
    private String company;
    private List<String> description;
    private String office;
    private String department;
    private String employmentType;
    private String seniority;
    private String schedule;
    private String occupationCategory;
}
