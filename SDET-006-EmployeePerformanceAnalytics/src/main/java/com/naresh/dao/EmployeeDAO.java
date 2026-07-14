package com.naresh.dao;

import com.naresh.db.DBConnection;
import com.naresh.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {


    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String query = "SELECT * FROM employees";


        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Employee emp = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("department")
                );

                employees.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return employees;
    }
}