package com.example.EasyFood.Restaurants.application.services;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Restaurant;
import com.example.EasyFood.Restaurants.domain.model.aggregates.Stock;
import com.example.EasyFood.Restaurants.domain.model.commands.CreateStockCommand;
import com.example.EasyFood.Restaurants.domain.model.commands.DeleteStockCommand;
import com.example.EasyFood.Restaurants.domain.model.commands.UpdateRestaurantCommand;
import com.example.EasyFood.Restaurants.domain.model.commands.UpdateStockCommand;
import com.example.EasyFood.Restaurants.domain.service.StockCommandService;
import com.example.EasyFood.Restaurants.infraestructure.persistence.jpa.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StockCommandServiceImpl implements StockCommandService {

    private final StockRepository stockRepository;

    public StockCommandServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Optional<Stock> handle(CreateStockCommand command) {
        var stock = new Stock(command);
        stockRepository.save(stock);
        return Optional.of(stock);
    }

    @Override
    public Optional<Stock> handle(UpdateStockCommand command) {
        var auxStock = stockRepository.findById(command.id());
        if (auxStock.isPresent()) {
            Stock stock = auxStock.get();
            stock.setName(command.name());
            stock.setQuantity(command.quantity());
            stock.setUnity(command.unity());
            return Optional.of(stock);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteStock(DeleteStockCommand command) {
        stockRepository.deleteById(command.id());
    }
}
