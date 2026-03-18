package com.InventoryManagementSystem.serviceimpl;

import com.InventoryManagementSystem.entity.UnitType;
import com.InventoryManagementSystem.repository.UnitTypeRepository;
import com.InventoryManagementSystem.service.UnitTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitTypeServiceImpl implements UnitTypeService {

    @Autowired
    private UnitTypeRepository unitTypeRepository;

    @Override
    public UnitType saveUnitType(UnitType unitType) {
        return unitTypeRepository.save(unitType);
    }

    @Override
    public List<UnitType> getAllUnitTypes() {
        return unitTypeRepository.findAll();
    }

    @Override
    public UnitType getUnitTypeById(Long id) {
        return unitTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUnitType(Long id) {
        unitTypeRepository.deleteById(id);
    }
}