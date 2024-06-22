package com.example.EasyFood.Restaurants.interfaces.rest.transform;

import com.example.EasyFood.Restaurants.domain.model.commands.CreateRestaurantCommand;
import com.example.EasyFood.Restaurants.interfaces.rest.resources.CreateRestaurantResource;

public class CreateRestaurantCommandFromResourceAssembler {
    public static CreateRestaurantCommand toCommandResource(CreateRestaurantResource resource) {
        return new CreateRestaurantCommand(resource.name(),resource.address(),resource.email(),resource.schedule(),resource.phone());
    }
}
