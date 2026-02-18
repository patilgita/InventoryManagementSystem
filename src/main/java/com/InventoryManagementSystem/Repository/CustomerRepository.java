package com.InventoryManagementSystem.Repository;

import com.InventoryManagementSystem.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByGstNumber(String gstNumber);

    Optional<Customer> findByEmail(String email);

    boolean existsByGstNumber(String gstNumber);

    boolean existsByEmail(String email);
}
