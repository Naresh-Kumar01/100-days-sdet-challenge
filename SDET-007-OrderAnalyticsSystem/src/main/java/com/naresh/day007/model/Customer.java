package com.naresh.day007.model;

public class Customer {
     private String city;
    private int customerId;
    private String customerName;
    private String email;
    private String phone;


    public Customer() {
    }


    public Customer(int customerId, String customerName, String email, String phone, String city) {
    this.customerId = customerId;
    this.customerName = customerName;
    this.email = email;
    this.phone = phone;
    this.city = city;
}


    public Customer(String customerName, String email, String phone) {
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
    }
                  
    public String getCity() {
    return city;
}


public void setCity(String city) {
    this.city = city;
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    
    @Override
public String toString() {
    return "Customer{" +
            "customerId=" + customerId +
            ", customerName='" + customerName + '\'' +
            ", email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            ", city='" + city + '\'' +
            '}';
}
}