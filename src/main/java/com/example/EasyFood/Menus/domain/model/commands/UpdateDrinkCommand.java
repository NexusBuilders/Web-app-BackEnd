package com.example.EasyFood.Menus.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record UpdateDrinkCommand(
        @NotBlank Long id,
        @NotBlank String name,
        @NotBlank Double price,
        @NotBlank String image
) {
}
