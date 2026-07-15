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
        String sql = "SELECT * FROM users WHERE username = ? AND password_hash = ?";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setString(1, username);
            statement.setString(2, password);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUser(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error during authentication", e);
        }
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

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, user.getEmployeeId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPasswordHash());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getPhone());
            statement.setString(8, user.getStatus());

            return statement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Error while creating user", e);
        }
    }

    @Override
    public User findById(int userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUser(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while finding user by ID", e);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
             
            while (resultSet.next()) {
                users.add(mapResultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching all users", e);
        }
        return users;
    }

    @Override
    public boolean updateUser(User user) {
        String sql = """
                UPDATE users SET 
                    first_name = ?, 
                    last_name = ?, 
                    email = ?, 
                    phone = ?, 
                    status = ? 
                WHERE username = ?
                """;
                
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getStatus());
            statement.setString(6, user.getUsername());
            
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error while updating user", e);
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setInt(1, userId);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting user", e);
        }
    }

    // Helper method to avoid code repetition
    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        // Agar aapke User model me 'id' set karne ka option hai, toh ise uncomment kar sakte hain:
        // user.setId(resultSet.getInt("id")); 
        user.setEmployeeId(resultSet.getString("employee_id"));
        user.setUsername(resultSet.getString("username"));
        user.setPasswordHash(resultSet.getString("password_hash"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone(resultSet.getString("phone"));
        user.setStatus(resultSet.getString("status"));
        return user;
    }
}