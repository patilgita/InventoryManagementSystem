package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Product;
import com.InventoryManagementSystem.Repository.ProductRepository;
import com.InventoryManagementSystem.Service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // CREATE PRODUCT
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // GET PRODUCT BY ID
    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    // GET ALL PRODUCTS
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // UPDATE PRODUCT
    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);

        if (existingProduct.isPresent()) {
            Product existing = existingProduct.get();

            existing.setProductCode(product.getProductCode());
            existing.setProductName(product.getProductName());
            existing.setProductType(product.getProductType());
            existing.setBrand(product.getBrand());
            existing.setUnit(product.getUnit());
            existing.setGstApplicable(product.isGstApplicable());
            existing.setPrice(product.getPrice());
            existing.setQuantity(product.getQuantity());
            existing.setDescription(product.getDescription());

            return productRepository.save(existing);
        }

        return null;
    }

    // DELETE PRODUCT
    @Override
    public void deleteProduct(Long id) {
        Optional<Product> existingProduct = productRepository.findById(id);
        existingProduct.ifPresent(productRepository::delete);
    }
}
