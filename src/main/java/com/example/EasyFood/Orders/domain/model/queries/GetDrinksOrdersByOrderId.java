package com.example.EasyFood.Orders.domain.model.queries;

public record GetDrinksOrdersByOrderId(Long orderId) {
    public GetDrinksOrdersByOrderId {
        if(orderId==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(orderId<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
