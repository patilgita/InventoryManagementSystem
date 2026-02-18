package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Shipment;
import com.InventoryManagementSystem.Repository.ShipmentRepository;
import com.InventoryManagementSystem.Service.ShipmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    // CREATE SHIPMENT
    @Override
    public Shipment createShipment(Shipment shipment) {
        // ✅ Use getCustomer() instead of getUser()
        if (shipment.getOrder() != null && shipment.getOrder().getCustomer() != null) {
            shipment.setCustomerMobile(shipment.getOrder().getCustomer().getPhone());
            shipment.setCustomerAddress(shipment.getOrder().getCustomer().getAddress());
        }
        return shipmentRepository.save(shipment);
    }

    // GET SHIPMENT BY ID
    @Override
    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found with ID: " + id));
    }

    // GET ALL SHIPMENTS
    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    // UPDATE SHIPMENT
    @Override
    public Shipment updateShipment(Long id, Shipment shipment) {
        Shipment existing = getShipmentById(id);

        existing.setShipmentName(shipment.getShipmentName());
        existing.setShipmentDate(shipment.getShipmentDate());
        existing.setShipmentAddress(shipment.getShipmentAddress());
        existing.setStatus(shipment.getStatus());
        existing.setSentByVendorName(shipment.getSentByVendorName());

        // ✅ Update customer info from Order
        if (shipment.getOrder() != null && shipment.getOrder().getCustomer() != null) {
            existing.setCustomerMobile(shipment.getOrder().getCustomer().getPhone());
            existing.setCustomerAddress(shipment.getOrder().getCustomer().getAddress());
        }

        existing.setOrder(shipment.getOrder());

        return shipmentRepository.save(existing);
    }

    // DELETE SHIPMENT
    @Override
    public void deleteShipment(Long id) {
        Shipment existing = getShipmentById(id);
        shipmentRepository.delete(existing);
    }
}
