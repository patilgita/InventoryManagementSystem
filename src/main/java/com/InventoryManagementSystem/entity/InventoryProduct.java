package com.InventoryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "products")
public class InventoryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private Double price;
    private Double mrp;

    private Boolean gstApplicable;
    private Double gstPercentage;

    private LocalDate productAddedDate;

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
    private InventoryProductType productType;

    @ManyToOne
    private InventoryBrand brand;

    @ManyToOne
    private InventoryVendor vendor;

    @ManyToOne
    private InventoryUnitType unitType;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<InventoryProductAttributeValue> attributes;

    public InventoryProduct() {
        this.productAddedDate = LocalDate.now();
    }
}