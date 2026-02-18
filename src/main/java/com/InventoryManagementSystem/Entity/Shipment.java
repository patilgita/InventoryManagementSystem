package com.InventoryManagementSystem.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_id", unique = true)
    private String trackingId;

    private String shipmentName;
    private LocalDate shipmentDate;

    @Column(name = "shipment_address")
    private String shipmentAddress;

    @Column(nullable = false)
    private String status = "CREATED";

    private String customerMobile;
    private String customerAddress;
    private String sentByVendorName;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public Shipment() {}

    public Long getId() { return id; }

    public String getTrackingId() { return trackingId; }
    public void setTrackingId(String trackingId) { this.trackingId = trackingId; }

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
