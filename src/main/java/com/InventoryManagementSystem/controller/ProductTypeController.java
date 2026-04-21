package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.ProductType;
import com.InventoryManagementSystem.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "https://pjsofttech.in")
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
    public ResponseEntity<?> getProductTypeById(@PathVariable Long id)
    {
        ProductType pt = productTypeService.getProductTypeById(id);

        if(pt == null)
        {
            return ResponseEntity.status(404).body("Product Type Not Found");
        }

        return ResponseEntity.ok(pt);
    }

    @DeleteMapping("/deleteProductType/{id}")
    public String deleteProductType(@PathVariable Long id)
    {
        productTypeService.deleteProductType(id);
        return "ProductType ID " + id + " deleted successfully";
    }
}