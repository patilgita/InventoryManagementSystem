package com.InventoryManagementSystem.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code", unique = true)
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_type")
    private String productType;

    private String brand; // 🔥 NEW FIELD

    private String unit; // pcs, box, etc.

    @Column(name = "gst_applicable")
    private boolean gstApplicable;

    private double price;
    private int quantity;
    private String description;

    public Product() {}

    public Product(String productCode, String productName, String productType,
                   String brand, String unit, boolean gstApplicable,
                   double price, int quantity, String description) {
        this.productCode = productCode;
        this.productName = productName;
        this.productType = productType;
        this.brand = brand;
        this.unit = unit;
        this.gstApplicable = gstApplicable;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    public Long getId() { return id; }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public boolean isGstApplicable() { return gstApplicable; }
    public void setGstApplicable(boolean gstApplicable) { this.gstApplicable = gstApplicable; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
