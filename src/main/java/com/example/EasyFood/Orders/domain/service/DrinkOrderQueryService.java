package com.example.EasyFood.Orders.domain.service;

import com.example.EasyFood.Menus.domain.model.queries.GetDrinksByRestaurantId;
import com.example.EasyFood.Orders.domain.model.aggregates.DrinkOrder;
import com.example.EasyFood.Orders.domain.model.queries.GetDrinksOrdersByOrderId;

import java.util.List;

public interface DrinkOrderQueryService {
    List<DrinkOrder> handle(GetDrinksOrdersByOrderId query);
}
