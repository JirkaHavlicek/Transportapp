package com.example.hr_module.entity.repository;


import com.example.hr_module.entity.AttendanceRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRecordRepository extends JpaRepository<AttendanceRecordEntity, Long> {
    List<AttendanceRecordEntity> findByEmployeeIdAndDate(Long employeeId, LocalDate date);
}
