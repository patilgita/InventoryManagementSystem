package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.Product;
import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    void deleteProduct(Long id);
}