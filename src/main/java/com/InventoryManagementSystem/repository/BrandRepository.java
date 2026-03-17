package com.InventoryManagementSystem.repository;

import com.InventoryManagementSystem.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
