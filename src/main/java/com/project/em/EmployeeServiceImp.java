package com.project.em;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired  
    private EmployeeRepository employeeRepository;

    List<EmployeeEntity> employees=new ArrayList<>();
    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity=new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Saved Successfully";
    }

    @Override
    public List<EmployeeEntity> readEmployees() {
        employees=employeeRepository.findAll();
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity emp=employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
        
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee=employeeRepository.findById(id).get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);

        return "Updated Employee";
    }

    @Override
    public Employee readEmployee(Long id) {
        EmployeeEntity employee=employeeRepository.findById(id).get();
        Employee existingEmployee=new Employee();
        existingEmployee.setId(employee.getId());
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setEmail(employee.getEmail());
        return existingEmployee;
    }


}
