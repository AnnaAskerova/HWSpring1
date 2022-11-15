package com.example.course3.employee.service;

import com.example.course3.employee.model.Employee;
import com.example.course3.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Имя/фамилия должны быть заполнены!");
        }
        Employee employee = new Employee(employeeRequest.getLastName(),
                employeeRequest.getLastName(), employeeRequest.getDepartment(),
                employeeRequest.getSalary());
        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public int getSalarySum() {
        return employees.values().stream()
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public int getMinSalary() {
        return employees.values().stream()
                .map(Employee::getSalary)
                .min(Integer::compareTo)
                .orElseGet(() -> 0);
    }

    public int getMaxSalary() {
        return employees.values().stream()
                .map(Employee::getSalary)
                .max(Integer::compareTo)
                .orElseGet(() -> 0);
    }

    public List<Employee> getMinSalaryEmployees() {
        int s = getMinSalary();
        return employees.values().stream()
                .filter(e -> e.getSalary() == s)
                .collect(Collectors.toList());
    }

    public List<Employee> getMaxSalaryEmployees() {
        int s = getMaxSalary();
        return employees.values().stream()
                .filter(e -> e.getSalary() == s)
                .collect(Collectors.toList());
    }

    public int getAverage() {
        double s = employees.values().stream()
                .mapToInt(Employee::getSalary)
                .average().orElseGet(() -> 0);
        return (int) s;
    }

    public List<Employee> getHighSalary() {
        int s = getAverage();
        return employees.values().stream()
                .filter(e -> e.getSalary() > s)
                .collect(Collectors.toList());
    }
}
