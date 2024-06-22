package com.example.EasyFood.Orders.interfaces.rest.transform;

import com.example.EasyFood.Orders.domain.model.aggregates.DrinkOrder;
import com.example.EasyFood.Orders.interfaces.rest.resources.DrinkOrderResource;

public class DrinkOrderResourceFromEntityAssembler {
    public static DrinkOrderResource toResourceFromEntity(DrinkOrder entity){
        return new DrinkOrderResource(entity.getId(),entity.getQuantity(),entity.getDrinkId(),entity.getOrderId());
    }
}
