package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Brand;
import com.InventoryManagementSystem.repository.BrandRepository;
import com.InventoryManagementSystem.service.BrandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Brand not found with ID: " + id));
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand updateBrand(Long id, Brand brand) {
        Brand existing = getBrandById(id);
        existing.setBrandName(brand.getBrandName());
        existing.setVendor(brand.getVendor());
        return brandRepository.save(existing);
    }

    @Override
    public void deleteBrand(Long id) {
        Brand existing = getBrandById(id);
        brandRepository.delete(existing);
    }
}
