package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.Vendor;

import java.util.List;

public interface VendorService {

    Vendor createVendor(Vendor vendor);

    Vendor getVendorById(Long id);

    List<Vendor> getAllVendors();

    Vendor updateVendor(Long id, Vendor vendor);

    void deleteVendor(Long id);
}
