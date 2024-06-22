package com.example.EasyFood.Menus.domain.model.queries;

public record GetLunchesByRestaurantId(Long restaurantId){
    public GetLunchesByRestaurantId {
        if(restaurantId==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(restaurantId<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
