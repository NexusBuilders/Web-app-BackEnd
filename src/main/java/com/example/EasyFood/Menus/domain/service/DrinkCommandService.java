package com.example.EasyFood.Menus.domain.service;

import com.example.EasyFood.Menus.domain.model.aggregates.Drink;
import com.example.EasyFood.Menus.domain.model.commands.CreateDrinkCommand;
import com.example.EasyFood.Menus.domain.model.commands.DeleteDrinkCommand;
import com.example.EasyFood.Menus.domain.model.commands.UpdateDrinkCommand;

import java.util.Optional;

public interface DrinkCommandService {
    Optional<Drink> handle(CreateDrinkCommand command);
    Optional<Drink> handle(UpdateDrinkCommand command);
    void deleteDrink(DeleteDrinkCommand command);
}
