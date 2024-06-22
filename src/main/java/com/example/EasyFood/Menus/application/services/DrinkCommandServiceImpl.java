package com.example.EasyFood.Menus.application.services;

import com.example.EasyFood.Menus.domain.model.aggregates.Drink;
import com.example.EasyFood.Menus.domain.model.aggregates.Lunch;
import com.example.EasyFood.Menus.domain.model.commands.CreateDrinkCommand;
import com.example.EasyFood.Menus.domain.model.commands.DeleteDrinkCommand;
import com.example.EasyFood.Menus.domain.model.commands.UpdateDrinkCommand;
import com.example.EasyFood.Menus.domain.service.DrinkCommandService;
import com.example.EasyFood.Menus.infraestructure.persistence.jpa.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrinkCommandServiceImpl implements DrinkCommandService {
    private final DrinkRepository drinkRepository;

    public DrinkCommandServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Optional<Drink> handle(CreateDrinkCommand command) {
        var drink = new Drink(command);
        drinkRepository.save(drink);
        return Optional.of(drink);
    }

    @Override
    public Optional<Drink> handle(UpdateDrinkCommand command) {
        var auxDrink = drinkRepository.findById(command.id());
        if (auxDrink.isPresent()) {
            Drink drink = auxDrink.get();
            drink.setName(command.name());
            drink.setPrice(command.price());
            drink.setImage(command.image());
            drinkRepository.save(drink);
            return Optional.of(drink);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteDrink(DeleteDrinkCommand command) {
        drinkRepository.deleteById(command.id());
    }
}
