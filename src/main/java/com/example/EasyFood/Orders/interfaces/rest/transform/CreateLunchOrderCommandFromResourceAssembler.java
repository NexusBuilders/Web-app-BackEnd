package com.example.EasyFood.Orders.interfaces.rest.transform;

import com.example.EasyFood.Orders.domain.model.commands.CreateLunchOrderCommand;
import com.example.EasyFood.Orders.interfaces.rest.resources.CreateLunchOrderResource;

public class CreateLunchOrderCommandFromResourceAssembler {
    public static CreateLunchOrderCommand toCommandResource(CreateLunchOrderResource resource) {
        return new CreateLunchOrderCommand(resource.quantity(), resource.lunchId(), resource.orderId());
    }
}
