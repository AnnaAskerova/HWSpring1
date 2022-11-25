package com.example.course3.employee.controller;

import com.example.course3.employee.model.Employee;
import com.example.course3.employee.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/{id}/employees")
    public List<Employee> getDepartment(@PathVariable("id") int id) {
        return this.departmentService.getDepartment(id);
    }

    @GetMapping("/department/{id}/salary/sum")
    public int getSalarySumOneDepartment(@PathVariable("id") int id) {
        return this.departmentService.getSalarySumOneDepartment(id);
    }

    @GetMapping("/department/{id}/salary/max")
    public int getMaxSalaryInDepartment(@PathVariable("id") int id) {
        return this.departmentService.getMaxSalaryInDepartment(id);
    }

    @GetMapping("/department/{id}/salary/min")
    public int getMinSalaryInDepartment(@PathVariable("id") int id) {
        return this.departmentService.getMinSalaryInDepartment(id);
    }

    @GetMapping("/department/employees")
    public Map<Integer, List<Employee>> getEmployeesSortedByDepartment() {
        return this.departmentService.getEmployeesSortedByDepartment();
    }

}
