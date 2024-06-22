package com.example.EasyFood.Menus.interfaces.rest.transform;

import com.example.EasyFood.Menus.domain.model.commands.CreateLunchCommand;
import com.example.EasyFood.Menus.interfaces.rest.resources.CreateLunchResource;

public class CreateLunchCommandFromResourceAssembler {
    public static CreateLunchCommand toCommandResource(CreateLunchResource resource) {
        return new CreateLunchCommand(resource.starterPlate(),resource.mainDish(),resource.price(),resource.image(),resource.restaurantId());
    }
}
