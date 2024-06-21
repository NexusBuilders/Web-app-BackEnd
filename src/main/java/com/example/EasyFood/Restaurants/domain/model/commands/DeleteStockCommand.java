package com.example.EasyFood.Restaurants.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record DeleteStockCommand(
        @NotBlank Long id
) {
}
