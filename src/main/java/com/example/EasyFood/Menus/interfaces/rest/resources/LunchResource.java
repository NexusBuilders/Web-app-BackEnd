package com.example.EasyFood.Menus.interfaces.rest.resources;

public record LunchResource(
        Long id,
        String starterPlate,
        String mainDish,
        Double price,
        String image,
        int restaurantId
) {
}
