package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.ProductType;
import com.InventoryManagementSystem.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @PostMapping("/createProductType")
    public ProductType createProductType(@RequestBody ProductType productType)
    {
        return productTypeService.saveProductType(productType);
    }

    @GetMapping("/getAllProductTypes")
    public List<ProductType> getAllProductTypes()
    {
        return productTypeService.getAllProductTypes();
    }

    @GetMapping("/getProductTypeById/{id}")
    public ProductType getProductTypeById(@PathVariable Long id)
    {
        return productTypeService.getProductTypeById(id);
    }

    @DeleteMapping("/deleteProductType/{id}")
    public String deleteProductType(@PathVariable Long id)
    {
        productTypeService.deleteProductType(id);
        return "Id Deleted Successfully: " + id;
    }
}