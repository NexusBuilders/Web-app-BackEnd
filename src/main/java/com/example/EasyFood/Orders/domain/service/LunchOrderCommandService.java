package com.example.EasyFood.Orders.domain.service;

import com.example.EasyFood.Orders.domain.model.aggregates.LunchOrder;
import com.example.EasyFood.Orders.domain.model.commands.CreateLunchOrderCommand;

import java.util.Optional;

public interface LunchOrderCommandService {
    Optional<LunchOrder> handle(CreateLunchOrderCommand command);
}
