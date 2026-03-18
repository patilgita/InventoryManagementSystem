package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.UnitType;
import com.InventoryManagementSystem.service.UnitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/unit-types")
public class UnitTypeController {

    @Autowired
    private UnitTypeService unitTypeService;

    @PostMapping
    public UnitType createUnitType(@RequestBody UnitType unitType) {
        return unitTypeService.saveUnitType(unitType);
    }

    @GetMapping
    public List<UnitType> getAllUnitTypes() {
        return unitTypeService.getAllUnitTypes();
    }

    @GetMapping("/{id}")
    public UnitType getUnitTypeById(@PathVariable Long id) {
        return unitTypeService.getUnitTypeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUnitType(@PathVariable Long id) {
        unitTypeService.deleteUnitType(id);
    }
}