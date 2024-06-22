package com.example.EasyFood.Restaurants.infraestructure.persistence.jpa;

import com.example.EasyFood.Restaurants.domain.model.aggregates.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findRestaurantById(Long id);
    Optional<Restaurant> findRestaurantByUserId(Long userId);
}
