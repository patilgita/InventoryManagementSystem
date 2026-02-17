package com.InventoryManagementSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_type")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type_name")
    private String typeName;   // e.g. Electronics, Grocery

    @Column(name = "product_id")
    private Long productId;    // reference to product

    @Column(name = "product_name")
    private String productName;

    // Default Constructor
    public ProductType() {}

    // Constructor
    public ProductType(String typeName, Long productId, String productName) {
        this.typeName = typeName;
        this.productId = productId;
        this.productName = productName;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
