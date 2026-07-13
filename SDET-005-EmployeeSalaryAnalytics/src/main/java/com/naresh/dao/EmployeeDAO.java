package com.naresh.dao;

import com.naresh.model.Employee;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {

    List<Employee> getAllEmployees() throws SQLException;

    void addEmployee(Employee employee);

}