package com.example.EasyFood.Menus.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateLunchCommand(
        @NotBlank String starterPlate,
        @NotBlank String mainDish,
        @NotBlank Double price,
        @NotBlank String image,
        @NotBlank int restaurantId
) {
}
