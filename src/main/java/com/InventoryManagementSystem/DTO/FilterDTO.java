package com.InventoryManagementSystem.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDTO {

    private Long attributeId;  // attribute id (Size, Color)
    private String value;     // M, Black, 5kg

}