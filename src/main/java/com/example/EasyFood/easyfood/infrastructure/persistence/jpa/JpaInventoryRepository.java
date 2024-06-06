package com.example.EasyFood.easyfood.infrastructure.persistence.jpa;

import com.example.EasyFood.easyfood.domain.model.entities.Inventory;
import com.example.EasyFood.easyfood.domain.repository.InventoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaInventoryRepository extends JpaRepository<Inventory, Long>, InventoryRepository {
}
