package com.example.EasyFood.Restaurants.domain.service;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Stock;
import com.example.EasyFood.Restaurants.domain.model.queries.GetAllStocksByIdRestaurantQuery;
import com.example.EasyFood.Restaurants.domain.model.queries.GetStockByIdQuery;

import java.util.List;
import java.util.Optional;

public interface StockQueryService {
    Optional<Stock> handle(GetStockByIdQuery query);
    List<Stock> handle(GetAllStocksByIdRestaurantQuery query);
}
