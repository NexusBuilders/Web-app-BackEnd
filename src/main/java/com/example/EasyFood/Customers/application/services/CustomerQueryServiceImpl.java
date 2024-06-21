package com.example.EasyFood.Customers.application.services;

import com.example.EasyFood.Customers.domain.model.aggregates.Customer;
import com.example.EasyFood.Customers.domain.model.queries.GetCustomerByIdQuery;
import com.example.EasyFood.Customers.domain.service.CustomerQueryService;
import com.example.EasyFood.Customers.infraestructure.persistence.jpa.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerQueryServiceImpl implements CustomerQueryService {
    private final CustomerRepository customerRepository;

    public CustomerQueryServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Customer> handle(GetCustomerByIdQuery query) {
        return customerRepository.findCustomerById(query.id());
    }
}
