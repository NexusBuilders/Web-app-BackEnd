package com.example.EasyFood.Restaurants.application.services;
import com.example.EasyFood.Restaurants.domain.model.aggregates.Stock;
import com.example.EasyFood.Restaurants.domain.model.queries.GetAllStocksByIdRestaurantQuery;
import com.example.EasyFood.Restaurants.domain.model.queries.GetStockByIdQuery;
import com.example.EasyFood.Restaurants.domain.service.StockQueryService;
import com.example.EasyFood.Restaurants.infraestructure.persistence.jpa.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StockQueryServiceImpl implements StockQueryService {

    private final StockRepository stockRepository;

    public StockQueryServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public Optional<Stock> handle(GetStockByIdQuery query) {
        return stockRepository.findStockById(query.id());
    }

    @Override
    public List<Stock> handle(GetAllStocksByIdRestaurantQuery query) {
        return stockRepository.findAllById(query.restaurantId());
    }
}
