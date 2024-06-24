package com.example.EasyFood.Restaurants.interfaces.rest.resources;

public record RestaurantResource(
        Long id,
        String name,
        String address,
        String email,
        String schedule,
        String phone,
        int userId
) {
}
