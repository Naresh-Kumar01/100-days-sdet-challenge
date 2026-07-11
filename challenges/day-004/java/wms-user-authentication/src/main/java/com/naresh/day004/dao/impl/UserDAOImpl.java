package com.naresh.day004.dao.impl;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.naresh.day004.dao.UserDAO;
import com.naresh.day004.model.User;
import com.naresh.day004.util.DBConnection;


public class UserDAOImpl implements UserDAO {


    @Override
    public User authenticateUser(String username, String password) {

        return null;
    }


    @Override
    public boolean createUser(User user) {

        String sql = """
                INSERT INTO users
                (
                    employee_id,
                    username,
                    password_hash,
                    first_name,
                    last_name,
                    email,
                    phone,
                    status
                )
                VALUES
                (?, ?, ?, ?, ?, ?, ?, ?)
                """;


        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement =
                    connection.prepareStatement(sql)) {


            statement.setString(1, user.getEmployeeId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPasswordHash());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getPhone());
            statement.setString(8, user.getStatus());


            return statement.executeUpdate() > 0;


        } catch(SQLException e) {

            throw new RuntimeException(
                    "Error while creating user", e);
        }
    }


    @Override
    public User findById(int userId) {

        return null;

    }


    @Override
    public List<User> findAll() {

        return new ArrayList<>();

    }


    @Override
    public boolean updateUser(User user) {

        return false;

    }


    @Override
    public boolean deleteUser(int userId) {

        return false;

    }

}
