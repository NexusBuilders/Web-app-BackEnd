package com.example.EasyFood.Orders.domain.model.queries;

public record GetOrderByIdQuery(Long id) {
    public GetOrderByIdQuery {
        if(id==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(id<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
