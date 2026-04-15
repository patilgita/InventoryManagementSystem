package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.ProductTypeAttribute;
import java.util.List;

public interface ProductTypeAttributeService {

    ProductTypeAttribute save(ProductTypeAttribute pta);

    List<ProductTypeAttribute> getAll();

    ProductTypeAttribute getById(Long id);

    void delete(Long id);
}