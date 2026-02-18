package com.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.Entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    List<Product> searchProductsByName(String name);

    Product getProductByCode(String productCode);

    Product updateProduct(Long id, Product product);

    void updateProductStock(Long productId, int quantity);

    void deleteProduct(Long id);
}
