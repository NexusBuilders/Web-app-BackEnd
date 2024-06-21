package com.example.EasyFood.Restaurants.domain.model.queries;

public record GetAllStocksByIdRestaurantQuery(Long restaurantId) {
    public GetAllStocksByIdRestaurantQuery {
        if(restaurantId==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(restaurantId<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
