package com.InventoryManagementSystem.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class ProductCategoryController {

    private final ProductCategoryService service;

    public ProductCategoryController(ProductCategoryService service) {
        this.service = service;
    }

    @PostMapping("/createCategory")
    public ProductCategory createCategory(@RequestBody ProductCategory category) {
        return service.saveCategory(category);
    }

    @GetMapping("/getAllCategories")
    public List<ProductCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/getCategoryById/{id}")
    public ProductCategory getCategoryById(@PathVariable Long id) {
        return service.getCategoryById(id);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return "Category deleted successfully";
    }
}