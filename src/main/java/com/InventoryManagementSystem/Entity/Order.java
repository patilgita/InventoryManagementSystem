package com.InventoryManagementSystem.Entity;

import com.InventoryManagementSystem.Enum.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;
    private LocalTime orderTime;
    private double totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // Many Orders -> One User (Customer)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Customer user;

    // One Order -> One Shipment
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Shipment shipment;

    public Order() {}

    public Long getId() { return id; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public LocalTime getOrderTime() { return orderTime; }
    public void setOrderTime(LocalTime orderTime) { this.orderTime = orderTime; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public Customer getUser() { return user; }
    public void setUser(Customer user) { this.user = user; }

    public Shipment getShipment() { return shipment; }
    public void setShipment(Shipment shipment) { this.shipment = shipment; }
}
