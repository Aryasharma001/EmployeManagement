package com.project.em;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class EmpController {

    // List<Employee> employees=new ArrayList<>();
    
    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<EmployeeEntity> getAllEmployes() {
        return employeeService.readEmployees();
    }
    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.readEmployee(id);
    }
    

    @PostMapping("addEmploye")
    public String createEmploye(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(employeeService.deleteEmployee(id)){
            return "delete successfully";
        }
        else{
            return "not found";
        }

    }
    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        
        return employeeService.updateEmployee(id, employee);
        
    }

}
