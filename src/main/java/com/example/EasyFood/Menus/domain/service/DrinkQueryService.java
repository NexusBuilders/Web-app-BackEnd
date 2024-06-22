package com.example.EasyFood.Menus.domain.service;

import com.example.EasyFood.Menus.domain.model.aggregates.Drink;
import com.example.EasyFood.Menus.domain.model.queries.GetDrinkByIdQuery;
import com.example.EasyFood.Menus.domain.model.queries.GetDrinksByRestaurantId;

import java.util.List;
import java.util.Optional;

public interface DrinkQueryService {
    Optional<Drink> handle(GetDrinkByIdQuery query);
    List<Drink> handle(GetDrinksByRestaurantId query);
}
