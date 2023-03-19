package com.company.MobiConnect2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Client_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String location;
    private Date startDate;
    private Date endDate;

    //@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    //private Set<Project> projects;

}