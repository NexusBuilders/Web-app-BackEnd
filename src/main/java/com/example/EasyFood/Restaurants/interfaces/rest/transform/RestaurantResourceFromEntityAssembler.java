package com.example.EasyFood.Restaurants.interfaces.rest.transform;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Restaurant;
import com.example.EasyFood.Restaurants.interfaces.rest.resources.RestaurantResource;

public class RestaurantResourceFromEntityAssembler {
    public static RestaurantResource toResourceFromEntity(Restaurant entity) {
        return new RestaurantResource(entity.getId(),entity.getName(),entity.getAddress(),entity.getEmail(),entity.getSchedule(),entity.getPhone(), entity.getUserId());
    }
}
