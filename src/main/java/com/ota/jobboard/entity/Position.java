package com.ota.jobboard.entity;

import com.ota.jobboard.enums.Status;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String company;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private User postedBy;
}
