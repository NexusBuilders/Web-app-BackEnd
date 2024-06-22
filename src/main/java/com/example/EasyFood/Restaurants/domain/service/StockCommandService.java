package com.example.EasyFood.Restaurants.domain.service;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Stock;
import com.example.EasyFood.Restaurants.domain.model.commands.CreateStockCommand;
import com.example.EasyFood.Restaurants.domain.model.commands.DeleteStockCommand;
import com.example.EasyFood.Restaurants.domain.model.commands.UpdateStockCommand;

import java.util.Optional;

public interface StockCommandService {
    Optional<Stock> handle(CreateStockCommand command);
    Optional<Stock> handle(UpdateStockCommand command);
    void deleteStock(DeleteStockCommand command);
}
