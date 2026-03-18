package com.InventoryManagementSystem.service.impl;

import com.InventoryManagementSystem.entity.Payment;
import com.InventoryManagementSystem.repository.PaymentRepository;
import com.InventoryManagementSystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {

        // ensure date is set
        if (payment.getPaymentDate() == null) {
            payment.setPaymentDate(java.time.LocalDate.now());
        }

        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}