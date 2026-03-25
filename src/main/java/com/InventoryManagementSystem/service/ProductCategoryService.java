package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory saveCategory(ProductCategory category);

    List<ProductCategory> getAllCategories();

    ProductCategory getCategoryById(Long id);

    void deleteCategory(Long id);
}