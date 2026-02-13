package com.InventoryManagementSystem.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentName;
    private LocalDate shipmentDate;
    private String destination;
    private String status;

    // 🔗 Link Shipment with Order (One Order -> One Shipment)
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    // Default constructor
    public Shipment() {}

    // Constructor
    public Shipment(String shipmentName, LocalDate shipmentDate, String destination, String status, Order order) {
        this.shipmentName = shipmentName;
        this.shipmentDate = shipmentDate;
        this.destination = destination;
        this.status = status;
        this.order = order;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getShipmentName() {
        return shipmentName;
    }

    public void setShipmentName(String shipmentName) {
        this.shipmentName = shipmentName;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDate shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
