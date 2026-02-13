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
        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipmentById(Long id) {
        // Return null if shipment not found
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

            // Update fields here (example fields)
            existing.setShipmentName(shipment.getShipmentName());
            existing.setShipmentDate(shipment.getShipmentDate());
            existing.setDestination(shipment.getDestination());
            existing.setStatus(shipment.getStatus());

            return shipmentRepository.save(existing);
        }

        // Return null if shipment doesn't exist
        return null;
    }

    @Override
    public void deleteShipment(Long id) {
        Optional<Shipment> existingShipment = shipmentRepository.findById(id);
        existingShipment.ifPresent(shipmentRepository::delete);
    }
}
