package com.InventoryManagementSystem.Controller;

import com.InventoryManagementSystem.Entity.OrderItem;
import com.InventoryManagementSystem.Service.OrderItemService; // ✔ interface import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService; // ✔ inject interface

    // POST: http://localhost:8080/orders/1/items
    @PostMapping("/{orderId}/items")
    public OrderItem addOrderItem(
            @PathVariable Long orderId,
            @RequestBody OrderItem orderItem) {

        return orderItemService.createOrderItem(orderId, orderItem);
    }
}
