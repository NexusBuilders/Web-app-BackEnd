package com.example.EasyFood.Customers.domain.model.queries;

public record GetCustomerByIdQuery(Long id) {
    public GetCustomerByIdQuery {
        if(id==null){
            throw new IllegalArgumentException("id cannot be null");
        }
        if(id<0){
            throw new IllegalArgumentException("id cannot be negative");
        }
    }
}
