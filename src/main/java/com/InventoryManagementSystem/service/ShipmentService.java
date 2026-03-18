package com.InventoryManagementSystem.service;

import com.InventoryManagementSystem.entity.Shipment;

import java.util.List;

public interface ShipmentService {

    Shipment saveShipment(Shipment shipment);

    List<Shipment> getAllShipments();

    Shipment getShipmentById(Long id);

    void deleteShipment(Long id);
}