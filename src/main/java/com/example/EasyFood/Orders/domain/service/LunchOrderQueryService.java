package com.example.EasyFood.Orders.domain.service;

import com.example.EasyFood.Menus.domain.model.queries.GetLunchesByRestaurantId;
import com.example.EasyFood.Orders.domain.model.aggregates.LunchOrder;
import com.example.EasyFood.Orders.domain.model.queries.GetLunchesOrdersByOrderId;

import java.util.List;

public interface LunchOrderQueryService {
    List<LunchOrder> handle(GetLunchesOrdersByOrderId query);
}
