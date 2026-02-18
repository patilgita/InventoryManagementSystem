package com.InventoryManagementSystem.Controller;

import com.InventoryManagementSystem.Entity.ProductType;
import com.InventoryManagementSystem.Service.ProductTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-types")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping
    public ResponseEntity<ProductType> createProductType(@RequestBody ProductType productType) {
        return ResponseEntity.ok(productTypeService.createProductType(productType));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductType> getProductType(@PathVariable Long id) {
        return ResponseEntity.ok(productTypeService.getProductTypeById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductType>> getAllProductTypes() {
        return ResponseEntity.ok(productTypeService.getAllProductTypes());
    }
}
