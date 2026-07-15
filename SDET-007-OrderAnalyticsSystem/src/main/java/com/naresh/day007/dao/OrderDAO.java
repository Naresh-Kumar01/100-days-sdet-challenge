package com.naresh.day007.dao;

import com.naresh.day007.model.Order;

import java.util.List;

public interface OrderDAO {

    boolean addOrder(Order order);

    boolean updateOrder(Order order);

    boolean deleteOrder(int orderId);

    Order getOrderById(int orderId);

    List<Order> getAllOrders();

}