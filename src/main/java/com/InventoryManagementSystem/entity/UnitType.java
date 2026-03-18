package com.InventoryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "unit_types")
public class UnitType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String unitName;     // Example: KG, Litre, Piece
    private String description;  // Optional

    @OneToMany(mappedBy = "unitType")
    private List<Product> products;

    public UnitType() {}
}