package com.example.EasyFood.Orders.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateOrderCommand(
        @NotBlank String address,
        @NotBlank String arriveTime,
        @NotBlank Double totalAmount,
        @NotBlank int customerId
) {
}
