package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.OrderItem;

import java.util.List;

public interface OrderItemService {

    OrderItem saveOrderItem(OrderItem orderItem);

    List<OrderItem> getAllOrderItems();

    OrderItem getOrderItemById(Long id);

    void deleteOrderItem(Long id);
}