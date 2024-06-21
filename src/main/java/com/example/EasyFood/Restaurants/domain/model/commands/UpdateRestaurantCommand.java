package com.example.EasyFood.Restaurants.domain.model.commands;


import jakarta.validation.constraints.NotBlank;

public record UpdateRestaurantCommand(
        @NotBlank Long id,
        String name,
        String address,
        String email,
        String schedule,
        String phone
) {
}
