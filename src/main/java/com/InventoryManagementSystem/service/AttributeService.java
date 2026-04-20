package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.Attribute;
import java.util.List;

public interface AttributeService {

    List<Attribute> getAttributesByProductType(Long productTypeId);

    Attribute saveAttribute(Attribute attribute);
}
