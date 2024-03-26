package com.ota.jobboard.model.workzag;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Setter @Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class JobDescription {
    private String name;
    private String value;
}
