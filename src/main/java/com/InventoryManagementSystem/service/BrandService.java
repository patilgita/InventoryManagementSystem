package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.Brand;
import java.util.List;

public interface BrandService {
    Brand createBrand(Brand brand);
    Brand getBrandById(Long id);
    List<Brand> getAllBrands();
    Brand updateBrand(Long id, Brand brand);
    void deleteBrand(Long id);
}
