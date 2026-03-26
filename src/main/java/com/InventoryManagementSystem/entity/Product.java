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

    private Double price;
    private Double mrp;

    // 🔥 Stock field
    private Integer stock;

    // 🔥 Dropdown fields
    private String size;
    private String unit;
    private String color;

    private Boolean gstApplicable = false;
    private Double gstPercentage;

    private LocalDate productAddedDate;

    // 🔗 Relations
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vendor_id")
    @JsonIgnore
    private Vendor vendor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "unit_type_id")
    @JsonIgnore
    private UnitType unitType;

    public Product() {}

    @PrePersist
    public void setDate() {
        this.productAddedDate = LocalDate.now();
    }

    @Transient
    public Boolean getAvailable() {
        return stock != null && stock > 0;
    }
}

