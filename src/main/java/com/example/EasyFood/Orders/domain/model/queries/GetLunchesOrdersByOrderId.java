package com.example.EasyFood.Orders.domain.model.queries;

public record GetLunchesOrdersByOrderId(Long orderId) {
    public GetLunchesOrdersByOrderId {
        if(orderId==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(orderId<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
