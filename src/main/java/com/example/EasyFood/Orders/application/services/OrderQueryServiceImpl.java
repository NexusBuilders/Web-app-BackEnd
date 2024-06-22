package com.example.EasyFood.Orders.application.services;

import com.example.EasyFood.Orders.domain.model.aggregates.Order;
import com.example.EasyFood.Orders.domain.model.queries.GetOrderByIdQuery;
import com.example.EasyFood.Orders.domain.service.OrderQueryService;
import com.example.EasyFood.Orders.infaestructure.persistence.jpa.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderQueryServiceImpl implements OrderQueryService {

    private final OrderRepository repository;

    public OrderQueryServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Order> handle(GetOrderByIdQuery query) {
        return repository.findOrderById(query.id());
    }
}
