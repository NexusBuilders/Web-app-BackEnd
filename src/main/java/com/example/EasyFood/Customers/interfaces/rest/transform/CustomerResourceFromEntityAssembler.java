package com.example.EasyFood.Customers.interfaces.rest.transform;

import com.example.EasyFood.Customers.domain.model.aggregates.Customer;
import com.example.EasyFood.Customers.interfaces.rest.resources.CustomerResource;

public class CustomerResourceFromEntityAssembler {
    public static CustomerResource toResourceFromEntity(Customer entity){
        return new CustomerResource(entity.getId(),entity.getFirstName(),entity.getLastName(),entity.getEmail(),entity.getPhone(), entity.getUserId());
    }
}
