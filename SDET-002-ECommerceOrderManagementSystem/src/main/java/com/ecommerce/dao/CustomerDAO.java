package com.ecommerce.dao;

import com.ecommerce.model.CustomerPurchaseReport;
import com.ecommerce.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    private static final String HIGH_VALUE_CUSTOMERS = """
        SELECT
            c.customer_id,
            c.customer_name,
            SUM(o.quantity * p.price) AS total_purchase
        FROM orders o
        INNER JOIN customers c
            ON o.customer_id = c.customer_id
        INNER JOIN products p
            ON o.product_id = p.product_id
        WHERE o.status = ?
        GROUP BY c.customer_id, c.customer_name
        HAVING SUM(o.quantity * p.price) > ?
        ORDER BY total_purchase DESC
        """;

    public List<CustomerPurchaseReport> getHighValueCustomers() {

        List<CustomerPurchaseReport> customers = new ArrayList<>();

        try (
                Connection connection = DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(HIGH_VALUE_CUSTOMERS)
        ) {

            preparedStatement.setString(1, "Completed");
            preparedStatement.setDouble(2, 50000);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                CustomerPurchaseReport customer =
                        new CustomerPurchaseReport(
                                resultSet.getInt("customer_id"),
                                resultSet.getString("customer_name"),
                                resultSet.getDouble("total_purchase")
                        );

                customers.add(customer);
            }

        } catch (SQLException e) {

            throw new RuntimeException("Unable to fetch customers", e);

        }

        return customers;
    }

}
