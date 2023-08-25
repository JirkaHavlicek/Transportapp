package com.example.hr_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "employee")
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String addressesOfPermanentResidence;

    @Column(nullable = false)
    private Date birthdate;

    // TODO: 13.08.2023 Calculate from birthdate, someone cud made mistake.
    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String educationAttained;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String workingPositions;




}
