package com.example.EasyFood.Menus.interfaces.rest.transform;

import com.example.EasyFood.Menus.domain.model.aggregates.Lunch;
import com.example.EasyFood.Menus.interfaces.rest.resources.LunchResource;

public class LunchResourceFromEntityAssembler {
    public static LunchResource toResourceFromEntity(Lunch entity) {
        return new LunchResource(entity.getId(), entity.getStarterPlate(),entity.getMainDish(),entity.getPrice(),entity.getImage(),entity.getRestaurantId());
    }
}
