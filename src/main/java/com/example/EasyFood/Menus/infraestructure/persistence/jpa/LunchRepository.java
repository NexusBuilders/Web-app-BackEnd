package com.example.EasyFood.Menus.infraestructure.persistence.jpa;

import com.example.EasyFood.Menus.domain.model.aggregates.Lunch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LunchRepository extends JpaRepository<Lunch, Long> {
    Optional<Lunch> findLunchById(Long id);
    List<Lunch> findAllByRestaurantId(Long restaurantId);
}
