package com.example.EasyFood.Menus.interfaces.rest.transform;

import com.example.EasyFood.Menus.domain.model.aggregates.Drink;
import com.example.EasyFood.Menus.interfaces.rest.resources.DrinkResource;

public class DrinkResourceFromEntityAssembler {
    public static DrinkResource toResourceFromEntity(Drink entity) {
        return new DrinkResource(entity.getId(),entity.getName(),entity.getPrice(),entity.getImage(),entity.getRestaurantId());
    }
}
