package com.example.EasyFood.Menus.interfaces.rest.transform;

import com.example.EasyFood.Menus.domain.model.commands.CreateDrinkCommand;
import com.example.EasyFood.Menus.interfaces.rest.resources.CreateDrinkResource;

public class CreateDrinkCommandFromResourceAssembler {
    public static CreateDrinkCommand toCommandResource(CreateDrinkResource resource) {
        return new CreateDrinkCommand(resource.name(),resource.price(),resource.image(),resource.restaurantId());
    }
}
