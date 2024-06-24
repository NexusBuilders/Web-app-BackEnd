package com.example.EasyFood.Customers.domain.service;


import com.example.EasyFood.Customers.domain.model.aggregates.Customer;
import com.example.EasyFood.Customers.domain.model.commands.CreateCustomerCommand;
import com.example.EasyFood.Customers.domain.model.commands.UpdateCustomerCommand;

import java.util.Optional;

public interface CustomerCommandService {
    Optional<Customer> handle(CreateCustomerCommand command);
    Optional<Customer> handle(UpdateCustomerCommand command);
}
