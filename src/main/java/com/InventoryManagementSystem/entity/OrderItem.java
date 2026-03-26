package com.InventoryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    private Double price;       // price per unit
    private Double gstAmount;   // total GST
    private Double totalPrice;  // final total

    public OrderItem() {}

    @PrePersist
    @PreUpdate
    public void calculateValues() {

        if (product != null && quantity != null && quantity > 0) {

            // 1. Get price from product
            this.price = product.getPrice() != null ? product.getPrice() : 0.0;

            // 2. Calculate GST
            if (Boolean.TRUE.equals(product.getGstApplicable())
                    && product.getGstPercentage() != null) {

                this.gstAmount = (price * quantity * product.getGstPercentage()) / 100;
            } else {
                this.gstAmount = 0.0;
            }

            // 3. Calculate total price
            this.totalPrice = (price * quantity) + gstAmount;

        } else {
            this.price = 0.0;
            this.gstAmount = 0.0;
            this.totalPrice = 0.0;
        }
    }
}
