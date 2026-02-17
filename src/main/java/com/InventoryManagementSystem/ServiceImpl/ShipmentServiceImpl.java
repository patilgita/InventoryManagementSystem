package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Shipment;
import com.InventoryManagementSystem.Repository.ShipmentRepository;
import com.InventoryManagementSystem.Service.ShipmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {

        // 🔥 Fetch customer mobile & address from Order -> User
        if (shipment.getOrder() != null && shipment.getOrder().getUser() != null) {
            shipment.setCustomerMobile(shipment.getOrder().getUser().getPhone());
            shipment.setCustomerAddress(shipment.getOrder().getUser().getAddress());
        }

        // trackingId will be auto-generated (S1, S2) via @PostPersist
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipmentById(Long id) {
        Optional<Shipment> shipment = shipmentRepository.findById(id);
        return shipment.orElse(null);
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment updateShipment(Long id, Shipment shipment) {
        Optional<Shipment> existingShipment = shipmentRepository.findById(id);

        if (existingShipment.isPresent()) {
            Shipment existing = existingShipment.get();

            existing.setShipmentName(shipment.getShipmentName());
            existing.setShipmentDate(shipment.getShipmentDate());
            existing.setShipmentAddress(shipment.getShipmentAddress()); // renamed
            existing.setStatus(shipment.getStatus());
            existing.setSentByVendorName(shipment.getSentByVendorName());

            // update customer details again if order present
            if (shipment.getOrder() != null && shipment.getOrder().getUser() != null) {
                existing.setCustomerMobile(shipment.getOrder().getUser().getPhone());
                existing.setCustomerAddress(shipment.getOrder().getUser().getAddress());
            }

            existing.setOrder(shipment.getOrder());

            return shipmentRepository.save(existing);
        }

        return null;
    }

    @Override
    public void deleteShipment(Long id) {
        Optional<Shipment> existingShipment = shipmentRepository.findById(id);
        existingShipment.ifPresent(shipmentRepository::delete);
    }
}
