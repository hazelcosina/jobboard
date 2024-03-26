package com.ota.jobboard.model.workzag;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Setter @Getter
@XmlRootElement(name = "workzag-jobs")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkzagJobs {

    @XmlElement(name = "position")
    private List<JobPosition> positions;

}
