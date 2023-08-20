package com.example.hr_module.service;

import com.example.hr_module.entity.EmployeeEntity;
import com.example.hr_module.entity.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // TODO: 13.08.2023 Sanitation entries, special chars in names, 100 years old people, names longer than 300 chars atd.
    public EmployeeEntity createEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    public EmployeeEntity getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }
}
