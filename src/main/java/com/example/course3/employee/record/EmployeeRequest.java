package com.example.course3.employee.record;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private int department;
    private int salary;
    String valid = "qwertyuiopasdfghjklzxcvbnQWERTYUIOPASDFGHJKLZXCVBNM -";

    public void setFirstName(String firstName) {
        if (StringUtils.containsOnly(firstName, valid)) {
            this.firstName = StringUtils.capitalize(firstName.toLowerCase());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public void setLastName(String lastName) {
        if (StringUtils.containsOnly(lastName, valid)) {
            this.lastName = StringUtils.capitalize(lastName.toLowerCase());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }
}
