package com.InventoryManagementSystem.repository;

import com.InventoryManagementSystem.entity.ProductTypeAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeAttributeRepository extends JpaRepository<ProductTypeAttribute, Long> {

    List<ProductTypeAttribute> findByProductTypeId(Long productTypeId);
}