package com.company.MobiConnect2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Project_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class Project {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String ownerClient;
    private String ownerConsultant;
    private Date startDate;
    private Date endDate;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;


    @ManyToMany(mappedBy = "projects",fetch = FetchType.LAZY)
    private Set<Employee> employees;
}
