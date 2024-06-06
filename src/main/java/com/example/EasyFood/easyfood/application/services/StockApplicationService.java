package com.example.EasyFood.easyfood.application.services;

import com.example.EasyFood.easyfood.domain.model.entities.Inventory;
import com.example.EasyFood.easyfood.domain.repository.InventoryRepository;
import com.example.EasyFood.easyfood.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class StockApplicationService {
    private final InventoryRepository inventoryRepository;

    public StockApplicationService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public String getStockDetails() {
        StringBuilder stockDetails = new StringBuilder();
        Iterable<Inventory> inventories = inventoryRepository.findAll();
        for (Inventory inventory : inventories) {
            stockDetails.append("Location: ").append(inventory.getLocation())
                    .append(", Stock: ").append(inventory.getStock()).append("\n");
        }
        return stockDetails.toString();
    }
}
