package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.Shipment;

import java.util.List;

public interface ShipmentService {

    Shipment createShipment(Shipment shipment);

    Shipment getShipmentById(Long id);

    List<Shipment> getAllShipments();

    Shipment updateShipment(Long id, Shipment shipment);

    void deleteShipment(Long id);

    Shipment getByTrackingId(String trackingId); // NEW METHOD
}