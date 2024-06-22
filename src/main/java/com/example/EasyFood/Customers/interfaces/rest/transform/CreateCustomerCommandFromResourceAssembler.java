package com.example.EasyFood.Customers.interfaces.rest.transform;

import com.example.EasyFood.Customers.domain.model.commands.CreateCustomerCommand;
import com.example.EasyFood.Customers.interfaces.rest.resources.CreateCustomerResource;

public class CreateCustomerCommandFromResourceAssembler {
    public static CreateCustomerCommand toCommandResource(CreateCustomerResource resource) {
        return new CreateCustomerCommand(resource.firstName(),resource.lastName(),resource.email(),resource.phone(), resource.userId());
    }
}
