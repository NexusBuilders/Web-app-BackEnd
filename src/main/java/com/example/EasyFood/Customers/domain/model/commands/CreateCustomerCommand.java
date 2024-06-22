package com.example.EasyFood.Customers.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

public record CreateCustomerCommand(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank String email,
        @NotBlank String phone

) {
}
