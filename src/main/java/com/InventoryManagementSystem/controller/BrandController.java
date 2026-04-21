package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.Brand;
import com.InventoryManagementSystem.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "https://pjsofttech.com")
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/createBrand")
    public Brand createBrand(@RequestBody Brand brand)
    {
        return brandService.saveBrand(brand);
    }

    @GetMapping("/getAllBrands")
    public List<Brand> getAllBrands()
    {
        return brandService.getAllBrands();
    }

    @GetMapping("/getBrandById/{id}")
    public Brand getBrandById(@PathVariable Long id)
    {
        return brandService.getBrandById(id);
    }

    @DeleteMapping("/deleteBrand/{id}")
    public String deleteBrand(@PathVariable Long id)
    {
        brandService.deleteBrand(id);
        return "Brand ID " + id + " deleted successfully";
    }
}