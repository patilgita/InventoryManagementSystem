package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Vendor;
import com.InventoryManagementSystem.Repository.VendorRepository;
import com.InventoryManagementSystem.Service.VendorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    // CREATE VENDOR
    @Override
    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // GET VENDOR BY ID
    @Override
    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + id));
    }

    // GET ALL VENDORS
    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // UPDATE VENDOR
    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Vendor existing = getVendorById(id);

        existing.setName(vendor.getName());
        existing.setEmail(vendor.getEmail());
        existing.setPhone(vendor.getPhone());
        existing.setAddress(vendor.getAddress());
        existing.setCity(vendor.getCity());
        existing.setState(vendor.getState());
        existing.setPincode(vendor.getPincode());

        return vendorRepository.save(existing);
    }

    // DELETE VENDOR
    @Override
    public void deleteVendor(Long id) {
        Vendor existing = getVendorById(id);
        vendorRepository.delete(existing);
    }
}
