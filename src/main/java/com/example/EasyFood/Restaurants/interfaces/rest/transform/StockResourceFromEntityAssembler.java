package com.example.EasyFood.Restaurants.interfaces.rest.transform;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Stock;
import com.example.EasyFood.Restaurants.interfaces.rest.resources.StockResource;

public class StockResourceFromEntityAssembler {
    public static StockResource toResourceFromEntity(Stock entity) {
        return new StockResource(entity.getId(),entity.getName(),entity.getQuantity(),entity.getUnity(),entity.getRestaurantId());
    }
}
