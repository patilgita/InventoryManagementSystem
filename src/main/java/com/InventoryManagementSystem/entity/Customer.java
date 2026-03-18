package com.InventoryManagementSystem.entity;

import com.InventoryManagementSystem.Enum.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // customer_id

    private String customerName; // customer_name
    private String landmark;
    private String city;
    private String taluka; // Sub-district
    private String pincode;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private State state; // Enum dropdown

    @ManyToOne
    @JoinColumn(name = "vendor_id") // Links company_name to Vendor
    private Vendor vendor;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Order> orders;

    public Customer() {}
}