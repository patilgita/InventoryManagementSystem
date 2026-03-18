package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.ProductType;
import com.InventoryManagementSystem.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-types")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping
    public ProductType createProductType(@RequestBody ProductType productType) {
        return productTypeService.saveProductType(productType);
    }

    @GetMapping
    public List<ProductType> getAllProductTypes() {
        return productTypeService.getAllProductTypes();
    }

    @GetMapping("/{id}")
    public ProductType getProductTypeById(@PathVariable Long id) {
        return productTypeService.getProductTypeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductType(@PathVariable Long id) {
        productTypeService.deleteProductType(id);
    }
}