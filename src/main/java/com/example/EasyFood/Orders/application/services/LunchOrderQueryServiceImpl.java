package com.example.EasyFood.Orders.application.services;

import com.example.EasyFood.Menus.domain.model.queries.GetLunchesByRestaurantId;
import com.example.EasyFood.Orders.domain.model.aggregates.LunchOrder;
import com.example.EasyFood.Orders.domain.model.queries.GetLunchesOrdersByOrderId;
import com.example.EasyFood.Orders.domain.service.LunchOrderQueryService;
import com.example.EasyFood.Orders.infaestructure.persistence.jpa.LunchOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LunchOrderQueryServiceImpl implements LunchOrderQueryService {

    private final LunchOrderRepository lunchOrderRepository;

    public LunchOrderQueryServiceImpl(LunchOrderRepository lunchOrderRepository) {
        this.lunchOrderRepository = lunchOrderRepository;
    }

    @Override
    public List<LunchOrder> handle(GetLunchesOrdersByOrderId query) {
        return lunchOrderRepository.findAllByOrderId(query.orderId());
    }
}
