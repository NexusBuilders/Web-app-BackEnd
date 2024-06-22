package com.example.EasyFood.Orders.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateDrinkOrderCommand(
        @NotBlank int quantity,
        @NotBlank int drinkId,
        @NotBlank int orderId
) {
}
