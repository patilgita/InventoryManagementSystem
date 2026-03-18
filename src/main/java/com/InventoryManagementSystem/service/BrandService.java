package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.Brand;

import java.util.List;

public interface BrandService {

    Brand saveBrand(Brand brand);

    List<Brand> getAllBrands();

    Brand getBrandById(Long id);

    void deleteBrand(Long id);
}