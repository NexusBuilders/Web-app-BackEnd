package com.example.EasyFood.Menus.domain.model.commands;

import jakarta.validation.constraints.NotNull;

public record DeleteDrinkCommand(
        @NotNull Long id
) {
}
