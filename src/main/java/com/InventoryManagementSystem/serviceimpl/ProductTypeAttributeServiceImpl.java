package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Attribute;
import com.InventoryManagementSystem.entity.ProductType;
import com.InventoryManagementSystem.entity.ProductTypeAttribute;
import com.InventoryManagementSystem.repository.AttributeRepository;
import com.InventoryManagementSystem.repository.ProductTypeAttributeRepository;
import com.InventoryManagementSystem.repository.ProductTypeRepository;
import com.InventoryManagementSystem.service.ProductTypeAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeAttributeServiceImpl implements ProductTypeAttributeService {

    @Autowired
    private ProductTypeAttributeRepository repository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Autowired
    private AttributeRepository attributeRepository;

    @Override
    public ProductTypeAttribute save(ProductTypeAttribute pta) {

        Long productTypeId = pta.getProductType().getId();
        Long attributeId = pta.getAttribute().getId();


        ProductType productType = productTypeRepository.findById(productTypeId)
                .orElseThrow(() -> new RuntimeException("ProductType not found"));

        Attribute attribute = attributeRepository.findById(attributeId)
                .orElseThrow(() -> new RuntimeException("Attribute not found"));


        pta.setProductType(productType);
        pta.setAttribute(attribute);

        return repository.save(pta);
    }

    @Override
    public List<ProductTypeAttribute> getAll() {
        return repository.findAll();
    }

    @Override
    public ProductTypeAttribute getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
