package com.InventoryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private String unitType;   //KG, Litre, Piece

    @OneToMany(mappedBy = "unitType")
    private List<Product> products;

    public UnitType() {}
}