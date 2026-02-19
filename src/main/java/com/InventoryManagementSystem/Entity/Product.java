package com.InventoryManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code", unique = true)
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    private String brand;
    private String unit;

    @Column(name = "gst_applicable")
    private boolean gstApplicable;

    @Column(name = "gst_percentage")
    private double gstPercentage;

    private double price;
    private int quantity;
    private String description;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public Product() {}


}
