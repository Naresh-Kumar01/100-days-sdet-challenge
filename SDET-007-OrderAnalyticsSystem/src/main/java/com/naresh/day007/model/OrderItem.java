package com.naresh.day007.model;

public class OrderItem {

    private int itemId;
    private int orderId;
    private String productName;
    private int quantity;
    private double price;


    public OrderItem() {
    }


    public OrderItem(int itemId, int orderId, String productName, int quantity, double price) {
        this.itemId = itemId;
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }


    public OrderItem(int orderId, String productName, int quantity, double price) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }


    public int getItemId() {
        return itemId;
    }


    public void setItemId(int itemId) {
        this.itemId = itemId;
    }


    public int getOrderId() {
        return orderId;
    }


    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }


    public int getQuantity() {
        return quantity;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}