package com.example.EasyFood.Orders.application.services;

import com.example.EasyFood.Orders.domain.model.aggregates.LunchOrder;
import com.example.EasyFood.Orders.domain.model.commands.CreateLunchOrderCommand;
import com.example.EasyFood.Orders.domain.service.LunchOrderCommandService;
import com.example.EasyFood.Orders.infaestructure.persistence.jpa.LunchOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class LunchOrderCommandServiceImpl implements LunchOrderCommandService {

    private final LunchOrderRepository lunchOrderRepository;

    public LunchOrderCommandServiceImpl(LunchOrderRepository lunchOrderRepository) {
        this.lunchOrderRepository = lunchOrderRepository;
    }

    @Override
    public Optional<LunchOrder> handle(CreateLunchOrderCommand command) {
        var lunchOrder = new LunchOrder(command);
        lunchOrderRepository.save(lunchOrder);
        return Optional.of(lunchOrder);
    }
}
