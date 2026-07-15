package com.naresh.day007.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/order_management_db";

    private static final String USER = "root";

    private static final String PASSWORD = "root";


    public static Connection getConnection() {

        try {

            Connection connection =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            System.out.println("Database Connected Successfully");

            return connection;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }
}