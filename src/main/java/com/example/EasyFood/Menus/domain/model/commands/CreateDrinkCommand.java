package com.example.EasyFood.Menus.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateDrinkCommand(
    @NotBlank String name,
    @NotBlank Double price,
    @NotBlank String image,
    @NotBlank int restaurantId
) {
}
