package com.example.EasyFood.Restaurants.domain.model.queries;

public record GetRestaurantByUserIdQuery(Long userId) {
    public GetRestaurantByUserIdQuery {
        if(userId==null){
            throw new IllegalArgumentException("userId cannot be null");
        }
        if(userId<0){
            throw new IllegalArgumentException("userId cannot be negative");
        }
    }
}
