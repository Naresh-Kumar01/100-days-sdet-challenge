package com.naresh.day007.dao;

import com.naresh.day007.model.Customer;

import java.util.List;

public interface CustomerDAO {


    boolean addCustomer(Customer customer);


    boolean updateCustomer(Customer customer);


    boolean deleteCustomer(int customerId);


    List<Customer> getAllCustomers();

}