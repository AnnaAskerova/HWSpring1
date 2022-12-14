package com.example.course3.employee.controller;

import com.example.course3.employee.model.*;
import com.example.course3.employee.record.EmployeeRequest;
import com.example.course3.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employees/salary/sum")
    public int getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/employee/salary/min") //List, т к могут быть сотрудники с одинаковой зп
    public List<Employee> getMinSalary() {
        return this.employeeService.getMinSalaryEmployees();
    }

    @GetMapping("/employee/salary/max") //List, т к могут быть сотрудники с одинаковой зп
    public List<Employee> getMaxSalary() {
        return this.employeeService.getMaxSalaryEmployees();
    }

    @GetMapping("/employee/high-salary")
    public List<Employee> getHighSalary() {
        return this.employeeService.getHighSalary();
    }

}
