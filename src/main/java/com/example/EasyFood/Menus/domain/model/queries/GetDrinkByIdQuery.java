package com.example.EasyFood.Menus.domain.model.queries;

public record GetDrinkByIdQuery(Long id) {
    public GetDrinkByIdQuery {
        if(id==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(id<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
