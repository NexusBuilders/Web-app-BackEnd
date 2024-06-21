package com.example.EasyFood.Restaurants.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record UpdateStockCommand(
        @NotBlank Long id,
        String name,
        int quantity,
        String unity
) {
}
