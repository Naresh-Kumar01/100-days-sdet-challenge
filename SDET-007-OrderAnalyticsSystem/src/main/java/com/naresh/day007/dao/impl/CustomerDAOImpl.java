package com.naresh.day007.dao.impl;

import com.naresh.day007.dao.CustomerDAO;
import com.naresh.day007.model.Customer;
import com.naresh.day007.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {


    @Override
    public boolean addCustomer(Customer customer) {

        String sql = """
                INSERT INTO customers
                (customer_name,email,phone,city)
                VALUES(?,?,?,?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {


            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhone());
            statement.setString(4, customer.getCity());


            int rows = statement.executeUpdate();

            return rows > 0;


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



    @Override
    public boolean updateCustomer(Customer customer) {

        String sql = """
                UPDATE customers
                SET customer_name=?,
                    email=?,
                    phone=?,
                    city=?
                WHERE customer_id=?
                """;


        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){


            statement.setString(1, customer.getCustomerName());
            statement.setString(2, customer.getEmail());
            statement.setString(3, customer.getPhone());
            statement.setString(4, customer.getCity());
            statement.setInt(5, customer.getCustomerId());


            return statement.executeUpdate() > 0;


        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }



    @Override
    public boolean deleteCustomer(int customerId) {


        String sql = """
                DELETE FROM customers
                WHERE customer_id=?
                """;


        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){


            statement.setInt(1, customerId);

            return statement.executeUpdate() > 0;


        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }



    @Override
    public List<Customer> getAllCustomers() {


        List<Customer> customers = new ArrayList<>();

        String sql = "SELECT * FROM customers";


        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()){


            while(resultSet.next()){


                Customer customer = new Customer();


                customer.setCustomerId(
                        resultSet.getInt("customer_id")
                );


                customer.setCustomerName(
                        resultSet.getString("customer_name")
                );


                customer.setEmail(
                        resultSet.getString("email")
                );


                customer.setPhone(
                        resultSet.getString("phone")
                );


                customer.setCity(
                        resultSet.getString("city")
                );


                customers.add(customer);
            }


        }catch(SQLException e){
            e.printStackTrace();
        }


        return customers;
    }
}