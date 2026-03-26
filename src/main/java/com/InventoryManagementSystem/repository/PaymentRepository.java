package com.InventoryManagementSystem.repository;

import com.InventoryManagementSystem.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}