package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.Order;
import com.InventoryManagementSystem.entity.Shipment;
import com.InventoryManagementSystem.repository.OrderRepository;
import com.InventoryManagementSystem.repository.ShipmentRepository;
import com.InventoryManagementSystem.service.ShipmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final OrderRepository orderRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository,
                               OrderRepository orderRepository) {
        this.shipmentRepository = shipmentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Shipment createShipment(Shipment shipment) {

        // Check if order exists
        Long orderId = shipment.getOrder().getId();

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        shipment.setOrder(order);

        return shipmentRepository.save(shipment);
    }

    @Override
    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment updateShipment(Long id, Shipment shipment) {
        Shipment existing = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        existing.setTrackingId(shipment.getTrackingId());
        existing.setTrackingLink(shipment.getTrackingLink());
        existing.setShipmentName(shipment.getShipmentName());
        existing.setShipmentDate(shipment.getShipmentDate());
        existing.setShipmentAddress(shipment.getShipmentAddress());
        existing.setStatus(shipment.getStatus());
        existing.setCustomerMobile(shipment.getCustomerMobile());
        existing.setCustomerAddress(shipment.getCustomerAddress());
        existing.setSentByVendorName(shipment.getSentByVendorName());

        return shipmentRepository.save(existing);
    }

    @Override
    public void deleteShipment(Long id) {
        shipmentRepository.deleteById(id);
    }

    @Override
    public Shipment getByTrackingId(String trackingId) {
        return shipmentRepository.findByTrackingId(trackingId)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));
    }
}