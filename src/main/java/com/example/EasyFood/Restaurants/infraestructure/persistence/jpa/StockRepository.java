package com.example.EasyFood.Restaurants.infraestructure.persistence.jpa;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findStockById(Long id);
    List<Stock> findAllById(Long restaurantId);
}
