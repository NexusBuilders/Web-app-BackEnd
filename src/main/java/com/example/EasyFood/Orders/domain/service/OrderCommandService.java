package com.example.EasyFood.Orders.domain.service;

import com.example.EasyFood.Orders.domain.model.aggregates.Order;
import com.example.EasyFood.Orders.domain.model.commands.CreateOrderCommand;

import java.util.Optional;

public interface OrderCommandService {
    Optional<Order> handle(CreateOrderCommand command);
}
