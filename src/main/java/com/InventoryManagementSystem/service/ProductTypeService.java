package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.ProductType;

import java.util.List;

public interface ProductTypeService {

    ProductType saveProductType(ProductType productType);

    List<ProductType> getAllProductTypes();

    ProductType getProductTypeById(Long id);

    void deleteProductType(Long id);
}