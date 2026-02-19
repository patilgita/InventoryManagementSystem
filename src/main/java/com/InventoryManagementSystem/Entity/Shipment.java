package com.InventoryManagementSystem.Entity;

import com.InventoryManagementSystem.Enum.ShipmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tracking_id", unique = true)
    private String trackingId;

    @Column(name = "tracking_link")
    private String trackingLink;

    private String shipmentName;
    private LocalDate shipmentDate;

    @Column(name = "shipment_address")
    private String shipmentAddress;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ShipmentStatus status = ShipmentStatus.PREPARING;

    private String customerMobile;
    private String customerAddress;
    private String sentByVendorName;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public Shipment() {}


}
