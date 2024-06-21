package com.example.EasyFood.Orders.domain.service;

import com.example.EasyFood.Orders.domain.model.aggregates.DrinkOrder;
import com.example.EasyFood.Orders.domain.model.commands.CreateDrinkOrderCommand;

import java.util.Optional;

public interface DrinkOrderCommandService {
    Optional<DrinkOrder> handle(CreateDrinkOrderCommand command);
}
