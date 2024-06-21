package com.example.EasyFood.Menus.application.services;

import com.example.EasyFood.Menus.domain.model.aggregates.Drink;
import com.example.EasyFood.Menus.domain.model.queries.GetDrinkByIdQuery;
import com.example.EasyFood.Menus.domain.model.queries.GetDrinksByRestaurantId;
import com.example.EasyFood.Menus.domain.service.DrinkQueryService;
import com.example.EasyFood.Menus.infraestructure.persistence.jpa.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DrinkQueryServiceImpl implements DrinkQueryService {

    private final DrinkRepository drinkRepository;

    public DrinkQueryServiceImpl(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Optional<Drink> handle(GetDrinkByIdQuery query) {
        return drinkRepository.findDrinkById(query.id());
    }

    @Override
    public List<Drink> handle(GetDrinksByRestaurantId query) {
        return drinkRepository.findAllByRestaurantId(query.restaurantId());
    }
}
