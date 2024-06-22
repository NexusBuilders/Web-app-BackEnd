package com.example.EasyFood.Restaurants.interfaces.rest.transform;

import com.example.EasyFood.Restaurants.domain.model.commands.CreateStockCommand;
import com.example.EasyFood.Restaurants.interfaces.rest.resources.CreateStockResource;

public class CreateStockCommandFromResourceAssembler {
    public static CreateStockCommand toCommandResource(CreateStockResource resource) {
        return new CreateStockCommand(resource.name(),resource.quantity(),resource.unity(),resource.restaurantId());
    }
}
