package com.InventoryManagementSystem.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Auto tracking id like S1, S2
    @Column(name = "tracking_id", unique = true)
    private String trackingId;

    private String shipmentName;
    private LocalDate shipmentDate;

    @Column(name = "shipment_address") // renamed from destination
    private String shipmentAddress;

    private String status;

    // Fetch from customer (User) table via Order
    private String customerMobile;
    private String customerAddress;

    // Vendor who sent shipment
    private String sentByVendorName;

    // 🔗 One Order -> One Shipment
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Shipment() {}

    public Shipment(String shipmentName, LocalDate shipmentDate, String shipmentAddress,
                    String status, String customerMobile, String customerAddress,
                    String sentByVendorName, Order order) {
        this.shipmentName = shipmentName;
        this.shipmentDate = shipmentDate;
        this.shipmentAddress = shipmentAddress;
        this.status = status;
        this.customerMobile = customerMobile;
        this.customerAddress = customerAddress;
        this.sentByVendorName = sentByVendorName;
        this.order = order;
    }

    // Auto-generate tracking id like S1, S2
    @PostPersist
    public void generateTrackingId() {
        this.trackingId = "S" + this.id;
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getTrackingId() { return trackingId; }

    public String getShipmentName() { return shipmentName; }
    public void setShipmentName(String shipmentName) { this.shipmentName = shipmentName; }

    public LocalDate getShipmentDate() { return shipmentDate; }
    public void setShipmentDate(LocalDate shipmentDate) { this.shipmentDate = shipmentDate; }

    public String getShipmentAddress() { return shipmentAddress; }
    public void setShipmentAddress(String shipmentAddress) { this.shipmentAddress = shipmentAddress; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCustomerMobile() { return customerMobile; }
    public void setCustomerMobile(String customerMobile) { this.customerMobile = customerMobile; }

    public String getCustomerAddress() { return customerAddress; }
    public void setCustomerAddress(String customerAddress) { this.customerAddress = customerAddress; }

    public String getSentByVendorName() { return sentByVendorName; }
    public void setSentByVendorName(String sentByVendorName) { this.sentByVendorName = sentByVendorName; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}
