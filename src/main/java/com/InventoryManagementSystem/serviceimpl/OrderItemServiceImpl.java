package com.InventoryManagementSystem.service.impl;

import com.InventoryManagementSystem.entity.OrderItem;
import com.InventoryManagementSystem.repository.OrderItemRepository;
import com.InventoryManagementSystem.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem saveOrderItem(OrderItem orderItem) {

        // GST + Total calculation
        double base = orderItem.getPrice() * orderItem.getQuantity();
        double gst = base * 0.18; // 18% GST

        orderItem.setGstAmount(gst);
        orderItem.setTotalPrice(base + gst);

        return orderItemRepository.save(orderItem);
    }

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}