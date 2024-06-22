package com.example.EasyFood.Orders.application.services;

import com.example.EasyFood.Orders.domain.model.aggregates.DrinkOrder;
import com.example.EasyFood.Orders.domain.model.commands.CreateDrinkOrderCommand;
import com.example.EasyFood.Orders.domain.service.DrinkOrderCommandService;
import com.example.EasyFood.Orders.infaestructure.persistence.jpa.DrinkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DrinkOrderCommandServiceImpl implements DrinkOrderCommandService {

    private final DrinkOrderRepository drinkOrderRepository;

    public DrinkOrderCommandServiceImpl(DrinkOrderRepository drinkOrderRepository) {
        this.drinkOrderRepository = drinkOrderRepository;
    }

    @Override
    public Optional<DrinkOrder> handle(CreateDrinkOrderCommand command) {
        var drinkOrder = new DrinkOrder(command);
        drinkOrderRepository.save(drinkOrder);
        return Optional.of(drinkOrder);
    }
}
