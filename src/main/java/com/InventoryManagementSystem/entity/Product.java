package com.InventoryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private Double price;   // selling price
    private Double mrp;     // MRP

    private String productCode;

    private Boolean gstApplicable;
    private Double gstPercentage;

    private Integer quantity;
    private String description;

    private LocalDate productAddedDate;

    // Product Type
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    @JsonIgnore
    private ProductType productType;

    // Brand
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    // Vendor
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @JsonIgnore
    private Vendor vendor;

    // Unit Type
    @ManyToOne
    @JoinColumn(name = "unit_type_id")
    @JsonIgnore
    private UnitType unitType;

    public Product() {}
}