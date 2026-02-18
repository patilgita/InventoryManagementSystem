package com.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.Entity.Payment;
import com.InventoryManagementSystem.Enum.PaymentStatus;

import java.util.List;

public interface PaymentService {

    Payment createPayment(Long orderId, Payment payment);

    Payment getPaymentById(Long id);

    List<Payment> getAllPayments();

    List<Payment> getPaymentsByOrderId(Long orderId);

    Payment updatePaymentStatus(Long id, PaymentStatus status);

    // ✅ New method to update amount + status
    Payment updatePayment(Long id, double amount, PaymentStatus status);

    void deletePayment(Long id);
}
