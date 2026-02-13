package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Payment;
import com.InventoryManagementSystem.Repository.PaymentRepository;
import com.InventoryManagementSystem.Service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment updatePayment(Long id, Payment payment) {
        Payment existing = getPaymentById(id);

        if (existing != null) {
            existing.setAmount(payment.getAmount());
            existing.setPaymentDate(payment.getPaymentDate());
            existing.setPaymentMethod(payment.getPaymentMethod());
            return paymentRepository.save(existing);
        }

        return null;
    }

    @Override
    public void deletePayment(Long id) {
        Payment existing = getPaymentById(id);
        if (existing != null) {
            paymentRepository.delete(existing);
        }
    }
}
