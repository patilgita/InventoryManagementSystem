package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.ProductCategory;
import com.InventoryManagementSystem.repository.ProductCategoryRepository;
import com.InventoryManagementSystem.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository repository;

    public ProductCategoryServiceImpl(ProductCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductCategory saveCategory(ProductCategory category) {
        return repository.save(category);
    }

    @Override
    public List<ProductCategory> getAllCategories() {
        return repository.findAll();
    }

    @Override
    public ProductCategory getCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}