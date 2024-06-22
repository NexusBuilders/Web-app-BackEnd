package com.example.EasyFood.Customers.application.services;

import com.example.EasyFood.Customers.domain.model.aggregates.Customer;
import com.example.EasyFood.Customers.domain.model.commands.CreateCustomerCommand;
import com.example.EasyFood.Customers.domain.model.commands.UpdateCustomerCommand;
import com.example.EasyFood.Customers.domain.service.CustomerCommandService;
import com.example.EasyFood.Customers.infraestructure.persistence.jpa.CustomerRepository;
import com.example.EasyFood.Restaurants.domain.model.aggregates.Restaurant;
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

    @Override
    public Optional<Customer> handle(UpdateCustomerCommand command) {
        var auxCustomer = customerRepository.findById(command.id());
        if (auxCustomer.isPresent()) {
            Customer customer = auxCustomer.get();
            customer.setFirstName(command.firstName());
            customer.setLastName(command.lastName());
            customer.setEmail(command.email());
            customer.setPhone(command.phone());
            return Optional.of(customer);
        } else {
            return Optional.empty();
        }
    }
}
