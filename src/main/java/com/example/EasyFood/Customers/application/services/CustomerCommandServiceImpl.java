package com.example.EasyFood.Customers.application.services;

import com.example.EasyFood.Customers.domain.model.aggregates.Customer;
import com.example.EasyFood.Customers.domain.model.commands.CreateCustomerCommand;
import com.example.EasyFood.Customers.domain.service.CustomerCommandService;
import com.example.EasyFood.Customers.infraestructure.persistence.jpa.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerCommandServiceImpl implements CustomerCommandService {
    private final CustomerRepository customerRepository;

    public CustomerCommandServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> handle(CreateCustomerCommand command) {
        var customer = new Customer(command);
        customerRepository.save(customer);
        return Optional.of(customer);
    }
}
