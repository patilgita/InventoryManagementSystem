package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.ProductTypeAttribute;
import com.InventoryManagementSystem.service.ProductTypeAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "https://pjsofttech.com")
@RestController
public class ProductTypeAttributeController {

    @Autowired
    private ProductTypeAttributeService service;

    @PostMapping("/createProductTypeAttribute")
    public ProductTypeAttribute create(@RequestBody ProductTypeAttribute pta)
    {
        return service.save(pta);
    }

    @GetMapping("/getAllProductTypeAttribute")
    public List<ProductTypeAttribute> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/getByIdProductTypeAttribute/{id}")
    public ProductTypeAttribute getById(@PathVariable Long id)
    {
        return service.getById(id);
    }

    @DeleteMapping("/deleteProductTypeAttribute/{id}")
    public String delete(@PathVariable Long id)
    {
        service.delete(id);
        return " ProductTypeAttribute ID " + id + " deleted successfully";
    }
}