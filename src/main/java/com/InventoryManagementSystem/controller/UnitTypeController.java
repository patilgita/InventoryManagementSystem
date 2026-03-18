package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.UnitType;
import com.InventoryManagementSystem.repository.UnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unit-types")
public class UnitTypeController {

    @Autowired
    private UnitTypeRepository unitTypeRepository;

    @PostMapping
    public UnitType addUnit(@RequestBody UnitType unitType) {
        return unitTypeRepository.save(unitType);
    }

    @GetMapping
    public List<UnitType> getAll() {
        return unitTypeRepository.findAll();
    }
}