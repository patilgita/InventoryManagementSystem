package com.InventoryManagementSystem.Entity;

import jakarta.persistence.*;

@Entity
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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public ProductType getProductType() { return productType; }
    public void setProductType(ProductType productType) { this.productType = productType; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public boolean isGstApplicable() { return gstApplicable; }
    public void setGstApplicable(boolean gstApplicable) { this.gstApplicable = gstApplicable; }

    public double getGstPercentage() { return gstPercentage; }
    public void setGstPercentage(double gstPercentage) { this.gstPercentage = gstPercentage; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Vendor getVendor() { return vendor; }
    public void setVendor(Vendor vendor) { this.vendor = vendor; }
}
