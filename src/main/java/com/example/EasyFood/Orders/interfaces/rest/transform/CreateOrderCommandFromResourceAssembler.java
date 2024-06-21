package com.example.EasyFood.Orders.interfaces.rest.transform;

import com.example.EasyFood.Orders.domain.model.commands.CreateOrderCommand;
import com.example.EasyFood.Orders.interfaces.rest.resources.CreateOrderResource;

public class CreateOrderCommandFromResourceAssembler {
    public static CreateOrderCommand toCommandResource(CreateOrderResource resource) {
        return new CreateOrderCommand(resource.address(), resource.arriveTime(), resource.totalAmount());
    }
}
