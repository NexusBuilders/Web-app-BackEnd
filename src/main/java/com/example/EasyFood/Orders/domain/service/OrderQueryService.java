package com.example.EasyFood.Orders.domain.service;

import com.example.EasyFood.Orders.domain.model.aggregates.Order;
import com.example.EasyFood.Orders.domain.model.queries.GetOrderByIdQuery;

import java.util.Optional;

public interface OrderQueryService {
    Optional<Order> handle(GetOrderByIdQuery query);
}
