package com.naresh.day007.dao.impl;

import com.naresh.day007.dao.OrderDAO;
import com.naresh.day007.model.Order;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(int orderId) {
        return false;
    }

    @Override
    public Order getOrderById(int orderId) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return null;
    }
}