package com.example.EasyFood.Restaurants.application.services;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Restaurant;
import com.example.EasyFood.Restaurants.domain.model.commands.CreateRestaurantCommand;
import com.example.EasyFood.Restaurants.domain.model.commands.UpdateRestaurantCommand;
import com.example.EasyFood.Restaurants.domain.service.RestaurantCommandService;
import com.example.EasyFood.Restaurants.infraestructure.persistence.jpa.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantCommandServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Optional<Restaurant> handle(CreateRestaurantCommand command) {
        var restaurant = new Restaurant(command);
        restaurantRepository.save(restaurant);
        return Optional.of(restaurant);
    }

    @Override
    public Optional<Restaurant> handle(UpdateRestaurantCommand command) {
        var auxRestaurant = restaurantRepository.findById(command.id());
        if (auxRestaurant.isPresent()) {
            Restaurant restaurant = auxRestaurant.get();
            restaurant.setName(command.name());
            restaurant.setAddress(command.address());
            restaurant.setEmail(command.email());
            restaurant.setSchedule(command.schedule());
            restaurant.setPhone(command.phone());
            restaurantRepository.save(restaurant);
            return Optional.of(restaurant);
        } else {
            return Optional.empty();
        }
    }
}
