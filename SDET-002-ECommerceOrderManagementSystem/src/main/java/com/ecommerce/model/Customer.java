package com.ecommerce.model;

public class Customer {

    private int customerId;
    private String customerName;
    private String city;
    private String email;

    public Customer() {
    }

    public Customer(int customerId, String customerName, String city, String email) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.city = city;
        this.email = email;
    }

    public Customer(String customerName, String city, String email) {
        this.customerName = customerName;
        this.city = city;
        this.email = email;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return customerId + " | " +
               customerName + " | " +
               city + " | " +
               email;
    }
}
