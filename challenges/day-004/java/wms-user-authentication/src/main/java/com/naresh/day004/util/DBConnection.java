package com.naresh.day004.util;

import com.naresh.day004.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private DBConnection() {
        // Prevent object creation
    }

    public static Connection getConnection() {

        try {

            Class.forName(DatabaseConfig.getDriver());

            return DriverManager.getConnection(
                    DatabaseConfig.getUrl(),
                    DatabaseConfig.getUsername(),
                    DatabaseConfig.getPassword());

        } catch (ClassNotFoundException e) {

            throw new RuntimeException("MySQL JDBC Driver not found.", e);

        } catch (SQLException e) {

            throw new RuntimeException("Database connection failed.", e);
        }
    }
}
