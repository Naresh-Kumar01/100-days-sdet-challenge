package com.naresh.day007;

import com.naresh.day007.util.DBConnection;

import java.sql.Connection;

public class TestDBConnection {

    public static void main(String[] args) {

        Connection connection = DBConnection.getConnection();

        if(connection != null){
            System.out.println("JDBC Connection Test Passed");
        }
    }
}