package com.example.course3.employee.model;

public class Employee {
    private static int count = 0;
    private final int id = ++count;
    private final String firstName;
    private final String lastName;
    private final int department;
    private final int salary;

    public Employee(String firstName, String middleName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = middleName;
        this.department = department;
        this.salary = salary;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
