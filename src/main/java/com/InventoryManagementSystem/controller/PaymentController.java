package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.Payment;
import com.InventoryManagementSystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "https://pjsofttech.in")
@RestController

public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/createPayment")
    public Payment createPayment(@RequestParam Long orderId,
                                 @RequestBody Payment payment)
    {
        return paymentService.createPayment(orderId, payment);
    }

    @GetMapping("/getAllPayments")
    public List<Payment> getAllPayments()
    {
        return paymentService.getAllPayments();
    }

    @GetMapping("/getPaymentById/{id}")
    public Payment getPaymentById(@PathVariable Long id)
    {
        return paymentService.getPaymentById(id);
    }

    @DeleteMapping("/deletePayment/{id}")
    public String deletePayment(@PathVariable Long id)
    {
        paymentService.deletePayment(id);
        return "Payment ID " + id + " deleted successfully";
    }
}