package com.example.EasyFood.Menus.domain.service;

import com.example.EasyFood.Menus.domain.model.aggregates.Lunch;
import com.example.EasyFood.Menus.domain.model.queries.GetLunchByIdQuery;
import com.example.EasyFood.Menus.domain.model.queries.GetLunchesByRestaurantId;

import java.util.List;
import java.util.Optional;

public interface LunchQueryService {
    Optional<Lunch> handle(GetLunchByIdQuery query);
    List<Lunch> handle(GetLunchesByRestaurantId query);

}
