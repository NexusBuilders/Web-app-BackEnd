package com.example.EasyFood.Orders.interfaces.rest.transform;

import com.example.EasyFood.Orders.domain.model.commands.CreateDrinkOrderCommand;
import com.example.EasyFood.Orders.interfaces.rest.resources.CreateDrinkOrderResource;

public class CreateDrinkOrderCommandFromResourceAssembler {
    public static CreateDrinkOrderCommand toCommandResource(CreateDrinkOrderResource resource) {
        return new CreateDrinkOrderCommand(resource.quantity(), resource.drinksId(),resource.orderId());
    }
}
