package com.example.course3.employee.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceEmptySetTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        when(employeeService.getAllEmployees()).thenReturn(Set.of());
    }

    @Test
    void getDepartment() {
        var actual = departmentService.getDepartment(1);
        assertEquals(0, actual.size());
        assertTrue(actual.isEmpty());
    }

    @Test
    void getSalarySumOneDepartment() {
        assertEquals(0, departmentService.getSalarySumOneDepartment(1));
    }

    @Test
    void getMaxSalaryInDepartment() {
        assertEquals(0, departmentService.getMaxSalaryInDepartment(1));
    }

    @Test
    void getMinSalaryInDepartment() {
        assertEquals(0, departmentService.getMinSalaryInDepartment(1));
    }

    @Test
    void getNumberOfDepartment() {
        assertEquals(0, departmentService.getNumberOfDepartment());
    }

    @Test
    void getEmployeesSortedByDepartment() {
        assertTrue(departmentService.getEmployeesSortedByDepartment().isEmpty());
    }
}
