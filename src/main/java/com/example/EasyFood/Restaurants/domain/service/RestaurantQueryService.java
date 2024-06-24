package com.example.EasyFood.Restaurants.domain.service;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Restaurant;
import com.example.EasyFood.Restaurants.domain.model.queries.GetAllRestaurantsQuery;
import com.example.EasyFood.Restaurants.domain.model.queries.GetRestaurantByIdQuery;
import com.example.EasyFood.Restaurants.domain.model.queries.GetRestaurantByUserIdQuery;

import java.util.List;
import java.util.Optional;

public interface RestaurantQueryService {
    Optional<Restaurant> handle(GetRestaurantByIdQuery query);
    List<Restaurant> handle(GetAllRestaurantsQuery query);
    Optional<Restaurant> handle(GetRestaurantByUserIdQuery query);
}
