package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.UnitType;

import java.util.List;

public interface UnitTypeService {

    UnitType saveUnitType(UnitType unitType);

    List<UnitType> getAllUnitTypes();

    UnitType getUnitTypeById(Long id);

    void deleteUnitType(Long id);
}