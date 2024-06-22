package com.example.EasyFood.Orders.domain.model.queries;

public record GetOrderByCustomerIdQuery(Long customerId) {
    public GetOrderByCustomerIdQuery {
        if(customerId==null){
            throw new IllegalArgumentException("customerId cannot be null");
        }
        if(customerId<0){
            throw new IllegalArgumentException("customerId cannot be negative");
        }
    }
}
