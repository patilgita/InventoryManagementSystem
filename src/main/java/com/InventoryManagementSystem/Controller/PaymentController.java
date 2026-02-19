package com.InventoryManagementSystem.Controller;

import com.InventoryManagementSystem.Entity.Payment;
import com.InventoryManagementSystem.Enum.PaymentStatus;
import com.InventoryManagementSystem.Service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/createorder/{orderId}")
    public ResponseEntity<Payment> createPayment(@PathVariable Long orderId,
                                                 @RequestBody Payment payment) {
        Payment savedPayment = paymentService.createPayment(orderId, payment);
        return ResponseEntity.ok(savedPayment);
    }

    @GetMapping("/getbyIdPayment/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }

    @GetMapping("/getallPayment")
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }


    @GetMapping("/getbyorderIdPayemnt/{orderId}")
    public ResponseEntity<List<Payment>> getPaymentsByOrderId(@PathVariable Long orderId) {
        List<Payment> payments = paymentService.getPaymentsByOrderId(orderId);
        return ResponseEntity.ok(payments);
    }

    @PutMapping("/updatePayment/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id,
                                                 @RequestParam double amount,
                                                 @RequestParam PaymentStatus status) {
        Payment updatedPayment = paymentService.updatePayment(id, amount, status);
        return ResponseEntity.ok(updatedPayment);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Payment> updatePaymentStatus(@PathVariable Long id,
                                                       @RequestParam PaymentStatus status) {
        Payment updatedPayment = paymentService.updatePaymentStatus(id, status);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/deletePayment/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.ok("Payment deleted successfully");
    }
}
