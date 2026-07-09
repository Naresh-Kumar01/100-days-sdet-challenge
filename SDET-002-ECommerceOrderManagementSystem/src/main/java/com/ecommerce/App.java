package com.ecommerce;

import com.ecommerce.model.CustomerPurchaseReport;
import com.ecommerce.service.CustomerService;

import java.util.List;

public class App {

    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();

        List<CustomerPurchaseReport> customers =
                customerService.getHighValueCustomers();

        System.out.println("\n==============================================");
        System.out.println(" HIGH VALUE CUSTOMER REPORT ");
        System.out.println("==============================================");

        if (customers.isEmpty()) {

            System.out.println("No High Value Customers Found.");

        } else {

            customers.forEach(System.out::println);

        }

    }

}
