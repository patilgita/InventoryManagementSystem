package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Product;
import com.InventoryManagementSystem.repository.ProductRepository;
import com.InventoryManagementSystem.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> searchProductsByName(String name) {
        return productRepository.findByProductNameContainingIgnoreCase(name);
    }

    @Override
    public Product getProductByCode(String productCode) {
        return productRepository.findByProductCode(productCode)
                .orElseThrow(() -> new RuntimeException("Product not found with code: " + productCode));
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);

        existing.setProductCode(product.getProductCode());
        existing.setProductName(product.getProductName());
        existing.setProductType(product.getProductType());
        existing.setBrand(product.getBrand());
        existing.setUnit(product.getUnit());
        existing.setGstApplicable(product.getGstApplicable()); // ✅ FIX
        existing.setPrice(product.getPrice());
        existing.setQuantity(product.getQuantity());
        existing.setDescription(product.getDescription());

        return productRepository.save(existing);
    }

    @Override
    public void updateProductStock(Long productId, int quantity) {
        Product existing = getProductById(productId);
        existing.setQuantity(quantity);
        productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        Product existing = getProductById(id);
        productRepository.delete(existing);
    }
}