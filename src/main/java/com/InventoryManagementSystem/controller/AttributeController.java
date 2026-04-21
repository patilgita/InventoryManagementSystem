package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.Attribute;
import com.InventoryManagementSystem.service.AttributeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "https://pjsofttech.in")
@RestController
public class AttributeController
{

    @Autowired
    private AttributeService service;

    @PostMapping("/createAttribute")
    public Attribute createAttribute(@RequestBody Attribute attribute)
    {
        return service.saveAttribute(attribute);
    }


    @GetMapping("/by-product-type/{id}")
    public List<Attribute> getByProductType(@PathVariable Long id)
    {
        return service.getAttributesByProductType(id);
    }
}