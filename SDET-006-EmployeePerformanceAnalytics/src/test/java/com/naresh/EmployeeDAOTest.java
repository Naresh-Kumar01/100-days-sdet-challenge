package com.naresh;

import com.naresh.dao.EmployeeDAO;
import com.naresh.model.Employee;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class EmployeeDAOTest {


    @Test
    public void verifyEmployeeRecordsAreFetched() {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        List<Employee> employees = employeeDAO.getAllEmployees();

        Assert.assertNotNull(employees);

        Assert.assertTrue(
                employees.size() > 0,
                "Employee data should be available"
        );

        System.out.println(
                "Total Employees: " + employees.size()
        );
    }


    @Test
    public void verifyEmployeeNames() {

        EmployeeDAO employeeDAO = new EmployeeDAO();

        List<Employee> employees =
                employeeDAO.getAllEmployees();


        boolean employeeFound = false;


        for(Employee employee : employees) {

            if(employee.getEmployeeName()
                    .equalsIgnoreCase("MADAM")) {

                employeeFound = true;
                break;
            }
        }


        Assert.assertTrue(
                employeeFound,
                "MADAM employee should exist"
        );
    }
}