package com.naresh;

import com.naresh.dao.EmployeeDAO;
import com.naresh.model.Employee;

public class Main {

    public static void main(String[] args) {

        EmployeeDAO dao = new EmployeeDAO();

        for(Employee emp : dao.getAllEmployees()) {
            System.out.println(emp);
        }
    }
}