package com.example.EasyFood.Menus.infraestructure.persistence.jpa;

import com.example.EasyFood.Menus.domain.model.aggregates.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    Optional<Drink> findDrinkById(Long id);
    List<Drink> findAllByRestaurantId(Long restaurantId);
}
