package com.InventoryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    private String productName;
    private Double price;

    private String productCode;
    private String unit;
    private Boolean gstApplicable;
    private Double gstPercentage;   // ✅ ADD THIS
    private Integer quantity;
    private String description;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    @JsonBackReference
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Product() {}
}