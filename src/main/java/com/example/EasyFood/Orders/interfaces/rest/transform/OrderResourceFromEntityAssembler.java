package com.example.EasyFood.Orders.interfaces.rest.transform;

import com.example.EasyFood.Orders.domain.model.aggregates.Order;
import com.example.EasyFood.Orders.interfaces.rest.resources.OrderResource;
import jakarta.persistence.Entity;

public class OrderResourceFromEntityAssembler {
    public static OrderResource toResourceFromEntity(Order entity){
        return  new OrderResource(entity.getId(), entity.getAddress(), entity.getArriveTime(), entity.getTotalAmount(),entity.getCustomerId());
    }
}
