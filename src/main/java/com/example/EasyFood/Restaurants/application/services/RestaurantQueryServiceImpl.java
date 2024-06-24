package com.example.EasyFood.Restaurants.application.services;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Restaurant;
import com.example.EasyFood.Restaurants.domain.model.queries.GetAllRestaurantsQuery;
import com.example.EasyFood.Restaurants.domain.model.queries.GetRestaurantByIdQuery;
import com.example.EasyFood.Restaurants.domain.model.queries.GetRestaurantByUserIdQuery;
import com.example.EasyFood.Restaurants.domain.service.RestaurantQueryService;
import com.example.EasyFood.Restaurants.infraestructure.persistence.jpa.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RestaurantQueryServiceImpl implements RestaurantQueryService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantQueryServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Optional<Restaurant> handle(GetRestaurantByIdQuery query) {
        return restaurantRepository.findRestaurantById(query.id());
    }

    @Override
    public List<Restaurant> handle(GetAllRestaurantsQuery query) {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> handle(GetRestaurantByUserIdQuery query) {
        return restaurantRepository.findRestaurantByUserId(query.userId());
    }
}
