package com.InventoryManagementSystem.entity;

import com.InventoryManagementSystem.Enum.State;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String ownerName;
    private String gstNo;

    private String landmark;
    private String city;
    private String taluka;
    @Enumerated(EnumType.STRING)
    private State state;
    private String pincode;

    private String email;
    private String phone;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> products;

    public Vendor() {}
}
