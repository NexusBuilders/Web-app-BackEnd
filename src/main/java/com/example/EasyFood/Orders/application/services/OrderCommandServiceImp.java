package com.example.EasyFood.Orders.application.services;

import com.example.EasyFood.Orders.domain.model.aggregates.Order;
import com.example.EasyFood.Orders.domain.model.commands.CreateOrderCommand;
import com.example.EasyFood.Orders.domain.service.OrderCommandService;
import com.example.EasyFood.Orders.infaestructure.persistence.jpa.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderCommandServiceImp implements OrderCommandService {
    private final OrderRepository repository;

    public OrderCommandServiceImp(OrderRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<Order> handle(CreateOrderCommand command) {
        var order = new Order(command);
        repository.save(order);
        return Optional.of(order);
    }
}
