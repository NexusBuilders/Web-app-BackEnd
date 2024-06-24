package com.example.EasyFood.Restaurants.interfaces.rest.resources;

public record CreateRestaurantResource(
        String name,
        String address,
        String email,
        String schedule,
        String phone,
        int userId
) {
}
