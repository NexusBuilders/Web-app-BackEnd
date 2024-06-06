package com.example.EasyFood.easyfood.domain.repository;

import com.example.EasyFood.easyfood.domain.model.entities.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository {
    Optional<Inventory> findById(Long id);
    Inventory save(Inventory inventory);
    void deleteById(Long id);
    List<Inventory> findAll();
}
