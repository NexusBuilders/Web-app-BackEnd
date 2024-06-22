package com.example.EasyFood.Orders.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateLunchOrderCommand(
        @NotBlank int quantity,
        @NotBlank int lunchId,
        @NotBlank int orderId
) {
}
