package com.example.course3.employee.service;

import com.example.course3.employee.model.Employee;
import com.example.course3.employee.record.EmployeeRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeService employeeService;
    Employee employee1;
    Employee employee2;
    Employee employee3;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
        employee1 = employeeService.addEmployee(new EmployeeRequest("One", "one", 1, 2500));
        employee2 = employeeService.addEmployee(new EmployeeRequest("Two", "Two", 1, 4000));
        employee3 = employeeService.addEmployee(new EmployeeRequest("Three", "Tree", 2, 7000));
    }

    @Test
    void getAllEmployees() {
        Collection<Employee> actual = employeeService.getAllEmployees();
        assertEquals(3, actual.size());
        Assertions.assertTrue(actual.containsAll(List.of(employee1, employee2, employee3)));
    }

    @Test
    void addValidEmployee() {
        EmployeeRequest request = new EmployeeRequest("Test", "Test", 1, 1250);
        Employee employee = employeeService.addEmployee(request);
        assertEquals(employee.getFirstName(), request.getFirstName());
        assertEquals(employee.getLastName(), request.getLastName());
        assertEquals(employee.getDepartment(), request.getDepartment());
        assertEquals(employee.getSalary(), request.getSalary());
    }

    @Test
    void addInvalidFirstNameEmployee() {
        EmployeeRequest er = new EmployeeRequest("1234", "test", 2, 2250);
        assertThrows(ResponseStatusException.class, () -> employeeService.addEmployee(er));
    }

    @Test
    void addInvalidLastNameEmployee() {
        EmployeeRequest er = new EmployeeRequest("test", "125", 6, 2500);
        assertThrows(ResponseStatusException.class, () -> employeeService.addEmployee(er));
    }

    @Test
    void addSameEmployee() {
        employeeService.addEmployee(new EmployeeRequest("test", "test", 1, 10000));
        employeeService.addEmployee(new EmployeeRequest("test", "test", 1, 10000));
        assertEquals(5, employeeService.getAllEmployees().size());
    }

    @Test
    void getSalarySum() {
        assertEquals(13500, employeeService.getSalarySum());
    }

    @Test
    void getMinSalary() {
        assertEquals(2500, employeeService.getMinSalary());
    }

    @Test
    void getMaxSalary() {
        assertEquals(7000, employeeService.getMaxSalary());
    }

    @Test
    void getMinSalaryEmployees() {
        assertIterableEquals(List.of(employee1), employeeService.getMinSalaryEmployees());
    }

    @Test
    void getMaxSalaryEmployees() {
        assertIterableEquals(List.of(employee3), employeeService.getMaxSalaryEmployees());
    }

    @Test
    void getAverage() {
        assertEquals(4500, employeeService.getAverage());
    }

    @Test
    void getHighSalary() {
        assertIterableEquals(List.of(employee3), employeeService.getHighSalary());
    }
}