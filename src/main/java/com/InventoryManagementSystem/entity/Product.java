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

    private Boolean gstApplicable;
    private Double gstPercentage;

    private LocalDate productAddedDate;


    private String size;
    private String color;
    String unit;

    private Integer stock;

    @Transient
    private Boolean available;

    @PostLoad
    @PostPersist
    @PostUpdate
    public void updateAvailability() {
        this.available = (this.stock != null && this.stock > 0);
    }

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "unit_type_id")
    private UnitType unitType;

    public Product() {
        this.productAddedDate = LocalDate.now();
    }
}