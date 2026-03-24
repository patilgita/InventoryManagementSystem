package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Vendor;
import com.InventoryManagementSystem.repository.VendorRepository;
import com.InventoryManagementSystem.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id).orElse(null);
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        return null;
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}