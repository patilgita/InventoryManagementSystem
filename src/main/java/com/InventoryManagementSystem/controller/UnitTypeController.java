package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.UnitType;
import com.InventoryManagementSystem.service.UnitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "https://pjsofttech.in")
@RestController
public class UnitTypeController {

    @Autowired
    private UnitTypeService unitTypeService;

    @PostMapping("/createUnitType")
    public UnitType createUnitType(@RequestBody UnitType unitType)
    {
        return unitTypeService.saveUnitType(unitType);
    }

    @GetMapping("/getAllUnitTypes")
    public List<UnitType> getAllUnitTypes()
    {
        return unitTypeService.getAllUnitTypes();
    }

    @GetMapping("/getUnitTypeById/{id}")
    public UnitType getUnitTypeById(@PathVariable Long id)
    {
        return unitTypeService.getUnitTypeById(id);
    }

    @DeleteMapping("/deleteUnitType/{id}")
    public String deleteUnitType(@PathVariable Long id)
    {
        unitTypeService.deleteUnitType(id);
        return "UnitType ID " + id + " deleted successfully";
    }
}