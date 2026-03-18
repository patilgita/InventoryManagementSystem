package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Product;
import com.InventoryManagementSystem.repository.ProductRepository;
import com.InventoryManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {

        // Auto set date
        product.setProductAddedDate(LocalDate.now());

        // GST logic (optional)
        if (product.getGstApplicable() != null && product.getGstApplicable()) {
            double gst = product.getPrice() * (product.getGstPercentage() / 100);
            product.setPrice(product.getPrice() + gst);
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}