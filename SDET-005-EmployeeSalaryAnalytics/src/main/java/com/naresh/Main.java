package com.naresh;

import com.naresh.dao.EmployeeDAO;
import com.naresh.dao.EmployeeDAOImpl;
import com.naresh.model.Employee;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println(" SDET-005 Employee Salary Analytics ");
        System.out.println("====================================");

        try {

            EmployeeDAO dao = new EmployeeDAOImpl();

            // Add New Employee
            Employee emp = new Employee(
                    111,
                    "Naresh",
                    "IT",
                    99000
            );

            dao.addEmployee(emp);

            // Fetch all employees
            List<Employee> employees = dao.getAllEmployees();

            // Print Header
            System.out.printf("%-5s %-12s %-12s %10s%n",
                    "ID", "Name", "Department", "Salary");
            System.out.println("------------------------------------------------");

            // Print Data
            employees.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}