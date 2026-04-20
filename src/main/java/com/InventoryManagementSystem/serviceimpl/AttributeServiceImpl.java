package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Attribute;
import com.InventoryManagementSystem.entity.ProductType;
import com.InventoryManagementSystem.entity.ProductTypeAttribute;
import com.InventoryManagementSystem.repository.AttributeRepository;
import com.InventoryManagementSystem.repository.ProductTypeAttributeRepository;
import com.InventoryManagementSystem.repository.ProductTypeRepository;
import com.InventoryManagementSystem.service.AttributeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private ProductTypeAttributeRepository repository;

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private ProductTypeRepository productTypeRepository;

    @Override
    public List<Attribute> getAttributesByProductType(Long productTypeId) {

        List<ProductTypeAttribute> list = repository.findByProductTypeId(productTypeId);

        return list.stream()
                .map(ProductTypeAttribute::getAttribute)
                .collect(Collectors.toList());
    }

    @Override
    public Attribute saveAttribute(Attribute attribute) {

        ProductType productType = productTypeRepository
                .findById(attribute.getProductType().getId())
                .orElseThrow(() -> new RuntimeException("ProductType not found"));

        attribute.setProductType(productType);

        Attribute savedAttribute = attributeRepository.save(attribute);

        ProductTypeAttribute mapping = new ProductTypeAttribute();
        mapping.setProductType(productType);
        mapping.setAttribute(savedAttribute);

        repository.save(mapping);

        return savedAttribute;
    }
}