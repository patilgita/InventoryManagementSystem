package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.OrderItem;
import java.util.List;

public interface OrderItemService {

    OrderItem createOrderItem(Long orderId, Long productId, Integer quantity);

    List<OrderItem> getAllOrderItems();

    OrderItem getOrderItemById(Long id);

    void deleteOrderItem(Long id);
}