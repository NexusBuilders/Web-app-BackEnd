package com.example.EasyFood.Restaurants.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateRestaurantCommand(
        @NotBlank String name,
        @NotBlank String address,
        @NotBlank String email,
        @NotBlank String schedule,
        @NotBlank String phone,
        @NotBlank int userId
) {
}
