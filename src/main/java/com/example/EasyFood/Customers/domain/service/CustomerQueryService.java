package com.example.EasyFood.Customers.domain.service;

import com.example.EasyFood.Customers.domain.model.aggregates.Customer;
import com.example.EasyFood.Customers.domain.model.queries.GetCustomerByIdQuery;
import com.example.EasyFood.Customers.domain.model.queries.GetCustomerByUserIdQuery;

import java.util.Optional;

public interface CustomerQueryService {
    Optional<Customer> handle(GetCustomerByIdQuery query);
    Optional<Customer> handle(GetCustomerByUserIdQuery query);
}
