package com.InventoryManagementSystem.controller;

import com.InventoryManagementSystem.entity.Shipment;
import com.InventoryManagementSystem.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @PostMapping("/createShipment")
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return shipmentService.saveShipment(shipment);
    }

    @GetMapping("/getAllShipments")
    public List<Shipment> getAllShipments() {
        return shipmentService.getAllShipments();
    }

    @GetMapping("/getShipmentById/{id}")
    public Shipment getShipmentById(@PathVariable Long id) {
        return shipmentService.getShipmentById(id);
    }

    @DeleteMapping("/deleteShipment/{id}")
    public void deleteShipment(@PathVariable Long id) {
        shipmentService.deleteShipment(id);
    }
}