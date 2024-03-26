package com.ota.jobboard.model.workzag;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
public class JobPosition {

    private Long id;
    private String subcompany;
    private String office;
    private String department;

    private String recruitingCategory;
    private String name;

    @XmlElementWrapper(name = "jobDescriptions")
    @XmlElement(name = "jobDescription")
    private List<JobDescription> jobDescriptions;

    private String employmentType;

    private String seniority;
    private String schedule;
    private String yearsOfExperience;
    private String keywords;
    private String occupation;
    private String occupationCategory;
    private String createdAt;



}