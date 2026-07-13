package com.naresh.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.naresh.model.Employee;
import com.naresh.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public List<Employee> getAllEmployees() throws SQLException {

        List<Employee> employees = new ArrayList<>();

        String sql = """
                SELECT
                    e.employee_id,
                    e.employee_name,
                    d.department_name,
                    e.salary
                FROM employees e
                JOIN departments d
                    ON e.department_id = d.department_id
                ORDER BY e.employee_id
                """;

        try (
                Connection con = DBUtil.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("department_name"),
                        rs.getDouble("salary")
                );

                employees.add(employee);
            }
        }

        return employees;
    }


    @Override
public void addEmployee(Employee employee) {

    String sql = """
            INSERT INTO employees(employee_id, employee_name, department_id, salary)
            VALUES (?, ?, ?, ?)
            """;

    try (
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
    ) {

        ps.setInt(1, employee.getEmployeeId());
        ps.setString(2, employee.getEmployeeName());

        // Temporary mapping
        if (employee.getDepartmentName().equalsIgnoreCase("IT")) {
            ps.setInt(3, 1);
        } else if (employee.getDepartmentName().equalsIgnoreCase("HR")) {
            ps.setInt(3, 2);
        } else {
            ps.setInt(3, 3);
        }

        ps.setDouble(4, employee.getSalary());

        int rows = ps.executeUpdate();

        System.out.println(rows + " Employee Added Successfully.");

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}