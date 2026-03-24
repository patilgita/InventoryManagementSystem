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


    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;


    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;


    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @JsonIgnore
    private Vendor vendor;


    @ManyToOne
    @JoinColumn(name = "unit_type_id")
    @JsonIgnore
    private UnitType unitType;

    public Product() {}
}