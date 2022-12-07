package com.example.course3.employee.service;

import com.example.course3.employee.model.Employee;
import com.example.course3.employee.record.EmployeeRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap<>();
    private static final String VALID = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM -";

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        String firstName = employeeRequest.getFirstName();
        String lastName = employeeRequest.getLastName();
        if (StringUtils.containsOnly(firstName, VALID)) { //этот метод сразу проверяет на null
            firstName = StringUtils.capitalize(firstName.toLowerCase());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.containsOnly(lastName, VALID)) {
            lastName = StringUtils.capitalize(lastName.toLowerCase());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Employee employee = new Employee(firstName, lastName,
                employeeRequest.getDepartment(),
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
