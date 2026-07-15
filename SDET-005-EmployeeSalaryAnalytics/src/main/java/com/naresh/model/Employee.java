package com.naresh.model;

public class Employee {

    private int employeeId;
    private String employeeName;
    private String departmentName;
    private double salary;

    public Employee(int employeeId,
                    String employeeName,
                    String departmentName,
                    double salary) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format(
            "%-5d %-12s %-12s %.2f",
                employeeId,
                employeeName,
                departmentName,
                salary
        );
    }
}