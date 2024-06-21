package com.example.EasyFood.Menus.domain.model.queries;

public record GetDrinksByRestaurantId(Long restaurantId) {
    public GetDrinksByRestaurantId {
        if(restaurantId==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(restaurantId<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
