package com.InventoryManagementSystem.service; import com.InventoryManagementSystem.entity.Vendor; import java.util.List;
public interface VendorService {

    Vendor saveVendor(Vendor vendor);

    List<Vendor> getAllVendors();

    Vendor getVendorById(Long id);

    Vendor updateVendor(Long id, Vendor vendor);

    void deleteVendor(Long id);
}