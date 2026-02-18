package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.OrderItem;
import com.InventoryManagementSystem.Service.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Override
    public OrderItem createOrderItem(Long orderId, OrderItem orderItem) {
        return null; // logic later
    }

    @Override
    public List<OrderItem> getItemsByOrderId(Long orderId) {
        return null;
    }

    @Override
    public void deleteOrderItem(Long id) {

    }
}
