package com.example.hr_module.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity(name = "AttendanceRecord")
@Getter
@Setter
public class AttendanceRecordEntity {
    @Id
    @SequenceGenerator(name = "AttendanceRecord_seq", sequenceName = "AttendanceRecord_seq", allocationSize = 1)
    private long id;

    private Long employeeId;

    private LocalDate date;

    private boolean cloclIn;


}
