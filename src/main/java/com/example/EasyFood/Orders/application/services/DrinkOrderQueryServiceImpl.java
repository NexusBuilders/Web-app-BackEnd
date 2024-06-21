package com.example.EasyFood.Orders.application.services;

import com.example.EasyFood.Menus.domain.model.queries.GetDrinksByRestaurantId;
import com.example.EasyFood.Orders.domain.model.aggregates.DrinkOrder;
import com.example.EasyFood.Orders.domain.model.queries.GetDrinksOrdersByOrderId;
import com.example.EasyFood.Orders.domain.service.DrinkOrderQueryService;
import com.example.EasyFood.Orders.infaestructure.persistence.jpa.DrinkOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DrinkOrderQueryServiceImpl implements DrinkOrderQueryService {

    private final DrinkOrderRepository drinkOrderRepository;

    public DrinkOrderQueryServiceImpl(DrinkOrderRepository drinkOrderRepository) {
        this.drinkOrderRepository = drinkOrderRepository;
    }

    @Override
    public List<DrinkOrder> handle(GetDrinksOrdersByOrderId query) {
        return drinkOrderRepository.findAllByOrderId(query.orderId());
    }
}
