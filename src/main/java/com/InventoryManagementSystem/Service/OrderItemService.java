package com.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.Entity.OrderItem;
import java.util.List;

public interface OrderItemService {

    OrderItem createOrderItem(Long orderId, OrderItem orderItem);

    List<OrderItem> getItemsByOrderId(Long orderId);

    void deleteOrderItem(Long id);
}
