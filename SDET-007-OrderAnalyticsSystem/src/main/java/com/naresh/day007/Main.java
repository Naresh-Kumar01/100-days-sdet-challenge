package com.naresh.day007;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import com.naresh.day007.dao.CustomerDAO;
import com.naresh.day007.dao.impl.CustomerDAOImpl;
import com.naresh.day007.model.Customer;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        System.out.println("======================================");
        System.out.println(" SDET-007 Order Analytics System");
        System.out.println("======================================");


        try {

            // Create DAO Object
            CustomerDAO customerDAO = new CustomerDAOImpl();


            // =================================
            // 1. INSERT CUSTOMER
            // =================================

            System.out.println("\n========== INSERT CUSTOMER ==========");


            Customer customer = new Customer();

            customer.setCustomerName("Naresh Kumar");
            customer.setEmail("naresh.kumar@gmail.com");
            customer.setPhone("9999999999");
            customer.setCity("Delhi");


            boolean isInserted = customerDAO.addCustomer(customer);


            if (isInserted) {

                System.out.println("✅ Customer inserted successfully.");

            } else {

                System.out.println("❌ Customer insertion failed.");

            }



            // =================================
            // 2. FETCH ALL CUSTOMERS
            // =================================

            System.out.println("\n========== CUSTOMER LIST ==========");


            List<Customer> customers = customerDAO.getAllCustomers();


            if(customers.isEmpty()){

                System.out.println("No customers found.");

            }
            else {

                customers.forEach(System.out::println);

            }



            // =================================
            // 3. UPDATE CUSTOMER
            // =================================

            /*
            System.out.println("\n========== UPDATE CUSTOMER ==========");


            Customer updateCustomer = new Customer();

            updateCustomer.setCustomerId(1);
            updateCustomer.setCustomerName("Naresh Updated");
            updateCustomer.setEmail("updated@gmail.com");
            updateCustomer.setPhone("8888888888");
            updateCustomer.setCity("Gurgaon");


            boolean updated =
                    customerDAO.updateCustomer(updateCustomer);


            if(updated){

                System.out.println("✅ Customer updated successfully.");

            }
            else{

                System.out.println("❌ Customer update failed.");

            }
            */



            // =================================
            // 4. DELETE CUSTOMER
            // =================================

            /*
            System.out.println("\n========== DELETE CUSTOMER ==========");


            boolean deleted =
                    customerDAO.deleteCustomer(1);


            if(deleted){

                System.out.println("✅ Customer deleted successfully.");

            }
            else{

                System.out.println("❌ Customer delete failed.");

            }
            */



        }
        catch(Exception e){

            System.out.println("Application Error:");
            e.printStackTrace();

        }
        finally {


            try {

                AbandonedConnectionCleanupThread.checkedShutdown();

            }
            catch(Exception e){

                e.printStackTrace();

            }


        }


        System.out.println("\n======================================");
        System.out.println(" Application Execution Completed ");
        System.out.println("======================================");

    }
}