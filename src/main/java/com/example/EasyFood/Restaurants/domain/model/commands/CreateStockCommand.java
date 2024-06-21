package com.example.EasyFood.Restaurants.domain.model.commands;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Restaurant;
import jakarta.validation.constraints.NotBlank;

public record CreateStockCommand (
        @NotBlank String name,
        @NotBlank int quantity,
        @NotBlank String unity,
        @NotBlank int restaurantId
){
}
