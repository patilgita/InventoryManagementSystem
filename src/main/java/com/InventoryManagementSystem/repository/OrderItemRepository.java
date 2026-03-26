package com.InventoryManagementSystem.repository;

import com.InventoryManagementSystem.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}