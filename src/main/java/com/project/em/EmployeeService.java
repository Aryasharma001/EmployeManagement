package com.project.em;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    String createEmployee(Employee employee);
    List<EmployeeEntity> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id,Employee employee);
     
}
