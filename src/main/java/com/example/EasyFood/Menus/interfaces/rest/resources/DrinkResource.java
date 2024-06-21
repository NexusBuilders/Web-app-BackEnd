package com.example.EasyFood.Menus.interfaces.rest.resources;

public record DrinkResource(
        Long id,
        String name,
        Double price,
        String image,
        int restaurantId

) {
}
