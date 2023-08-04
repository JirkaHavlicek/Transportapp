package com.example.hr_module.service;

import com.example.hr_module.entity.AttendanceRecordEntity;
import com.example.hr_module.entity.repository.AttendanceRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceRecordService {
    @Autowired
    private AttendanceRecordRepository attendanceRecordRepository;

    public AttendanceRecordEntity createAttendanceRecord(AttendanceRecordEntity attendanceRecord) {
        return attendanceRecordRepository.save(attendanceRecord);
    }

    public List<AttendanceRecordEntity> getAttendanceRecordsForEmployeeAndDate(Long employeeId, LocalDate date) {
        return attendanceRecordRepository.findByEmployeeIdAndDate(employeeId, date);
    }
}
