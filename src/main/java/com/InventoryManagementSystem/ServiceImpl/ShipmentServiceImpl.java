package com.InventoryManagementSystem.ServiceImpl;

import com.InventoryManagementSystem.Entity.Shipment;
import com.InventoryManagementSystem.Repository.ShipmentRepository;
import com.InventoryManagementSystem.Service.ShipmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {

        // 🔥 UNIQUE Tracking ID Generator
        String trackingId;
        Random random = new Random();

        do {
            trackingId = "TRK" + (1000 + random.nextInt(9000)); // TRK1000-TRK9999
        } while (shipmentRepository.existsByTrackingId(trackingId));

        shipment.setTrackingId(trackingId);

        // 🔗 Tracking Link
        shipment.setTrackingLink("http://localhost:8080/shipments/track/" + trackingId);

        // Auto customer details from Order
        if (shipment.getOrder() != null && shipment.getOrder().getCustomer() != null) {
            shipment.setCustomerMobile(shipment.getOrder().getCustomer().getPhone());
            shipment.setCustomerAddress(shipment.getOrder().getCustomer().getAddress());
        }

        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found with ID: " + id));
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment updateShipment(Long id, Shipment shipment) {
        Shipment existing = getShipmentById(id);

        existing.setShipmentName(shipment.getShipmentName());
        existing.setShipmentDate(shipment.getShipmentDate());
        existing.setShipmentAddress(shipment.getShipmentAddress());
        existing.setStatus(shipment.getStatus());
        existing.setSentByVendorName(shipment.getSentByVendorName());

        if (shipment.getOrder() != null && shipment.getOrder().getCustomer() != null) {
            existing.setCustomerMobile(shipment.getOrder().getCustomer().getPhone());
            existing.setCustomerAddress(shipment.getOrder().getCustomer().getAddress());
        }

        existing.setOrder(shipment.getOrder());

        return shipmentRepository.save(existing);
    }

    @Override
    public void deleteShipment(Long id) {
        Shipment existing = getShipmentById(id);
        shipmentRepository.delete(existing);
    }
}
