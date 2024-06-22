package com.example.EasyFood.Restaurants.domain.model.queries;

public record GetRestaurantByIdQuery(Long id) {
    public GetRestaurantByIdQuery {
        if(id==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(id<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
