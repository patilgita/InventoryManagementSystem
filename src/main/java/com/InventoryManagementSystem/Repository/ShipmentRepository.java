package com.InventoryManagementSystem.Repository;

import com.InventoryManagementSystem.Entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Optional<Shipment> findByTrackingId(String trackingId);

    Optional<Shipment> findByOrderId(Long orderId);

    boolean existsByTrackingId(String trackingId);
}
