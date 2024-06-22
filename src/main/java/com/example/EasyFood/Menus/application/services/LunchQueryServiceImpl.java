package com.example.EasyFood.Menus.application.services;

import com.example.EasyFood.Menus.domain.model.aggregates.Lunch;
import com.example.EasyFood.Menus.domain.model.queries.GetLunchByIdQuery;
import com.example.EasyFood.Menus.domain.model.queries.GetLunchesByRestaurantId;
import com.example.EasyFood.Menus.domain.service.LunchQueryService;
import com.example.EasyFood.Menus.infraestructure.persistence.jpa.LunchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LunchQueryServiceImpl implements LunchQueryService {

    private final LunchRepository lunchRepository;

    public LunchQueryServiceImpl(LunchRepository lunchRepository) {
        this.lunchRepository = lunchRepository;
    }

    @Override
    public Optional<Lunch> handle(GetLunchByIdQuery query) {
        return lunchRepository.findLunchById(query.id());
    }

    @Override
    public List<Lunch> handle(GetLunchesByRestaurantId query) {
        return lunchRepository.findAllByRestaurantId(query.restaurantId());
    }
}
