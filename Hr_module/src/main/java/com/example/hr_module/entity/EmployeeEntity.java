package com.example.hr_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String addressesOfPermanentResidence;

    @Column(nullable = false)
    private Date birthdate;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String educationAttained;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String workingPositions;




}
