package com.example.EasyFood.Menus.interfaces.rest.resources;

public record CreateLunchResource(
        String starterPlate,
        String mainDish,
        Double price,
        String image,
        int restaurantId


) {
}
