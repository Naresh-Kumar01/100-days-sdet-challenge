package com.ecommerce.service;

import com.ecommerce.dao.CustomerDAO;
import com.ecommerce.model.CustomerPurchaseReport;

import java.util.List;

public class CustomerService {

    private final CustomerDAO customerDAO = new CustomerDAO();

    public List<CustomerPurchaseReport> getHighValueCustomers() {

        return customerDAO.getHighValueCustomers();

    }

}
