package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment savePayment(Payment payment);

    List<Payment> getAllPayments();

    Payment getPaymentById(Long id);

    void deletePayment(Long id);
}