package com.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.Entity.Order;
import com.InventoryManagementSystem.Enum.OrderStatus;

import java.util.List;

public interface OrderService {

    Order createOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrders();

    List<Order> getOrdersByCustomerId(Long customerId);

    Order updateOrderStatus(Long id, OrderStatus status);

    void deleteOrder(Long id);
}
