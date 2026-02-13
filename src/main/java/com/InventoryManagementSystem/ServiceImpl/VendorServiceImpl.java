package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Vendor;
import com.InventoryManagementSystem.Repository.VendorRepository;
import com.InventoryManagementSystem.Service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
        Optional<Vendor> vendor = vendorRepository.findById(id);
        return vendor.orElse(null); // Return null if not found
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        Optional<Vendor> existingVendor = vendorRepository.findById(id);

        if (existingVendor.isPresent()) {
            Vendor existing = existingVendor.get();

            // 🔥 Update fields here (example fields)
            existing.setName(vendor.getName());
            existing.setEmail(vendor.getEmail());
            existing.setPhone(vendor.getPhone());
            existing.setAddress(vendor.getAddress());
            existing.setCity(vendor.getCity());
            existing.setState(vendor.getState());
            existing.setPincode(vendor.getPincode());

            return vendorRepository.save(existing);
        }

        return null; // Return null if vendor doesn't exist
    }

    @Override
    public void deleteVendor(Long id) {
        Optional<Vendor> existingVendor = vendorRepository.findById(id);
        existingVendor.ifPresent(vendorRepository::delete);
    }
}
