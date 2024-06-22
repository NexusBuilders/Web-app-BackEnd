package com.example.EasyFood.Restaurants.domain.service;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Restaurant;
import com.example.EasyFood.Restaurants.domain.model.commands.CreateRestaurantCommand;
import com.example.EasyFood.Restaurants.domain.model.commands.UpdateRestaurantCommand;

import java.util.Optional;

public interface RestaurantCommandService {
    Optional<Restaurant> handle(CreateRestaurantCommand command);
    Optional<Restaurant> handle(UpdateRestaurantCommand command);
}
