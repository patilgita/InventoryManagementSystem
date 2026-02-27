package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.OrderItem;
import com.InventoryManagementSystem.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping("/{orderId}/items")
    public OrderItem addOrderItem(
            @PathVariable Long orderId,
            @RequestBody OrderItem orderItem) {

        return orderItemService.createOrderItem(orderId, orderItem);
    }
}
