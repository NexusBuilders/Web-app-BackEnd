package com.example.EasyFood.Menus.interfaces.rest.resources;

public record CreateDrinkResource(
        String name,
        Double price,
        String image,
        int restaurantId
) {
}
