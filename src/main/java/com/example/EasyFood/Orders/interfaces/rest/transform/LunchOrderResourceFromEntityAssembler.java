package com.example.EasyFood.Orders.interfaces.rest.transform;

import com.example.EasyFood.Orders.domain.model.aggregates.LunchOrder;
import com.example.EasyFood.Orders.interfaces.rest.resources.LunchOrderResource;

public class LunchOrderResourceFromEntityAssembler {
    public static LunchOrderResource toResourceFromEntity(LunchOrder entity){
        return new LunchOrderResource(entity.getId(),entity.getQuantity(),entity.getLunchId(), entity.getOrderId());
    }
}
