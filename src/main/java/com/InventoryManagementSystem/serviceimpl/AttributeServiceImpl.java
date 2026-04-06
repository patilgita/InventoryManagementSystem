package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Attribute;
import com.InventoryManagementSystem.entity.ProductTypeAttribute;
import com.InventoryManagementSystem.repository.AttributeRepository;
import com.InventoryManagementSystem.repository.ProductTypeAttributeRepository;
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

    @Override
    public List<Attribute> getAttributesByProductType(Long productTypeId) {

        List<ProductTypeAttribute> list = repository.findByProductTypeId(productTypeId);

        return list.stream()
                .map(ProductTypeAttribute::getAttribute)
                .collect(Collectors.toList());
    }

    @Override
    public Attribute saveAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }
}