package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.*;
import com.InventoryManagementSystem.repository.*;
import com.InventoryManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private UnitTypeRepository unitTypeRepository;

    @Override
    public Product saveProduct(Product product) {

        Long productTypeId = product.getProductType().getId();
        Long brandId = product.getBrand().getId();
        Long vendorId = product.getVendor().getId();
        Long unitTypeId = product.getUnitType().getId();

        ProductType productType = productTypeRepository.findById(productTypeId)
                .orElseThrow(() -> new RuntimeException("ProductType not found"));

        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new RuntimeException("Brand not found"));

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        UnitType unitType = unitTypeRepository.findById(unitTypeId)
                .orElseThrow(() -> new RuntimeException("UnitType not found"));

        product.setProductType(productType);
        product.setBrand(brand);
        product.setVendor(vendor);
        product.setUnitType(unitType);

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