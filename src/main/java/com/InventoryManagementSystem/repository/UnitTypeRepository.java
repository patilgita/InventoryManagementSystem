package com.InventoryManagementSystem.repository;

import com.InventoryManagementSystem.entity.UnitType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitTypeRepository extends JpaRepository<UnitType, Long> {
}