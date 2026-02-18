package com.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.Entity.ProductType;
import java.util.List;

public interface ProductTypeService {
    ProductType createProductType(ProductType productType);
    ProductType getProductTypeById(Long id);
    List<ProductType> getAllProductTypes();
}
