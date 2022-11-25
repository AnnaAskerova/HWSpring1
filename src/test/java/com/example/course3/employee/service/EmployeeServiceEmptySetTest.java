package com.example.course3.employee.service;

import com.example.course3.employee.model.Employee;
import com.example.course3.employee.record.EmployeeRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceEmptySetTest {
    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void getEmptyAllEmployees() {
        assertIterableEquals(Set.of(), employeeService.getAllEmployees());
    }

    @Test
    void getEmptySalarySum() {
        assertEquals(0, employeeService.getSalarySum());
    }

    @Test
    void getMinSalaryIfEmpty() {
        assertEquals(0, employeeService.getMinSalary());
    }

    @Test
    void getMaxSalaryIfEmpty() {
        assertEquals(0, employeeService.getMaxSalary());
    }

    @Test
    void getMinSalaryEmployeesIfEmpty() {
        assertIterableEquals(List.of(), employeeService.getMinSalaryEmployees());
    }

    @Test
    void getMaxSalaryEmployeesIfEmpty() {
        assertIterableEquals(List.of(), employeeService.getMaxSalaryEmployees());
    }

    @Test
    void getAverageIfEmpty() {
        assertEquals(0, employeeService.getAverage());
    }

    @Test
    void getHighSalaryIfEmpty() {
        assertIterableEquals(List.of(), employeeService.getHighSalary());
    }
}