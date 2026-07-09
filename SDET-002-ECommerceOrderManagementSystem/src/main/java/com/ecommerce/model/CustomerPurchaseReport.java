package com.ecommerce.model;

public class CustomerPurchaseReport {

    private int customerId;
    private String customerName;
    private double totalPurchase;

    public CustomerPurchaseReport(int customerId,
                                  String customerName,
                                  double totalPurchase) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalPurchase = totalPurchase;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPurchase() {
        return totalPurchase;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer ID : %d%nCustomer Name : %s%nTotal Purchase : %.2f%n",
                customerId,
                customerName,
                totalPurchase);
    }
}
