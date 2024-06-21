package com.example.EasyFood.Restaurants.interfaces.rest.resources;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Restaurant;

public record StockResource(
        Long id,
        String name,
        int quantity,
        String unity,
        int restaurantId
) {
}
