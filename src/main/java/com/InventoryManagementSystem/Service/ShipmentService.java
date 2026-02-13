package com.InventoryManagementSystem.Service;

import com.InventoryManagementSystem.Entity.Shipment;

import java.util.List;

public interface ShipmentService {

    Shipment createShipment(Shipment shipment);

    Shipment getShipmentById(Long id);

    List<Shipment> getAllShipments();

    Shipment updateShipment(Long id, Shipment shipment);

    void deleteShipment(Long id);
}
