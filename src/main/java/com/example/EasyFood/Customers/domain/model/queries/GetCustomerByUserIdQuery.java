package com.example.EasyFood.Customers.domain.model.queries;

public record GetCustomerByUserIdQuery (Long userId){
    public GetCustomerByUserIdQuery {
        if(userId==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(userId<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
