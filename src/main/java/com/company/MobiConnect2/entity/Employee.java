package com.company.MobiConnect2.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Employee_TBL")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String contact;
    private String gender;
    private Date dateOfBirth;
    private String designation;
    private String address;
    private String workLocation;
    private Date dateOfJoin;
    private Date dateOfExit;
    private String manager;
    private int totalLeaves;
    private int leaveBalance;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Employee_project_TABLE",
            joinColumns = {
                    @JoinColumn(name = "employee_id",referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "project_id",referencedColumnName = "id")
            })
    private Set<Project> projects;

}
