package com.ota.jobboard.entity;

import com.ota.jobboard.enums.Role;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String emailAddress;
    @Enumerated(EnumType.STRING)
    private Role role;
}
