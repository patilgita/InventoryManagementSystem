package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.ProductType;
import com.InventoryManagementSystem.Repository.ProductTypeRepository;
import com.InventoryManagementSystem.Service.ProductTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    private final ProductTypeRepository productTypeRepository;

    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository) {
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public ProductType createProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    @Override
    public ProductType getProductTypeById(Long id) {
        return productTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductType not found"));
    }

    @Override
    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }
}
