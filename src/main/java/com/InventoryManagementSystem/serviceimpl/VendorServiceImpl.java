package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Vendor;
import com.InventoryManagementSystem.repository.VendorRepository;
import com.InventoryManagementSystem.service.VendorService;
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

    @Override
    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found with ID: " + id));
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }


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

    @Override
    public void deleteVendor(Long id) {
        Vendor existing = getVendorById(id);
        vendorRepository.delete(existing);
    }
}
