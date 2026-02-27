package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.ProductType;
import java.util.List;

public interface ProductTypeService {
    ProductType createProductType(ProductType productType);
    ProductType getProductTypeById(Long id);
    List<ProductType> getAllProductTypes();
}
