package com.InventoryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandName;

    // Vendor relationship
    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    @JsonBackReference   // ✅ FIX
    private Vendor vendor;

    // Product relationship
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    @JsonBackReference   // ✅ FIX
    private List<Product> products;

    public Brand() {}
}