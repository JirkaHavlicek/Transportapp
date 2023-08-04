package com.example.hr_module.controller;

import com.example.hr_module.entity.AttendanceRecordEntity;

import com.example.hr_module.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/attendance")
public class AttendanceRecordController {
    @Autowired
    private AttendanceRecordService attendanceRecordService;

    @PostMapping
    public ResponseEntity<AttendanceRecordEntity> createAttendanceRecord(@RequestBody AttendanceRecordEntity attendanceRecord) {
        AttendanceRecordEntity createdRecord = attendanceRecordService.createAttendanceRecord(attendanceRecord);
        return new ResponseEntity<>(createdRecord, HttpStatus.CREATED);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<List<AttendanceRecordEntity>> getAttendanceRecordsForEmployeeAndDate(
            @PathVariable Long employeeId,
            @RequestParam String date
    ) {
        LocalDate attendanceDate = LocalDate.parse(date);
        List<AttendanceRecordEntity> attendanceRecords = attendanceRecordService.getAttendanceRecordsForEmployeeAndDate(
                employeeId,
                attendanceDate
        );
        return new ResponseEntity<>(attendanceRecords, HttpStatus.OK);
    }
}
