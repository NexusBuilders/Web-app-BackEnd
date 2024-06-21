package com.example.EasyFood.Customers.interfaces.rest;

import com.example.EasyFood.Customers.domain.model.queries.GetCustomerByIdQuery;
import com.example.EasyFood.Customers.domain.service.CustomerCommandService;
import com.example.EasyFood.Customers.domain.service.CustomerQueryService;
import com.example.EasyFood.Customers.interfaces.rest.resources.CreateCustomerResource;
import com.example.EasyFood.Customers.interfaces.rest.resources.CustomerResource;
import com.example.EasyFood.Customers.interfaces.rest.transform.CreateCustomerCommandFromResourceAssembler;
import com.example.EasyFood.Customers.interfaces.rest.transform.CustomerResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/customers", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name= "Customer", description = "Customers management endpoints")
public class CustomerController {
    private final CustomerQueryService customerQueryService;
    private final CustomerCommandService customerCommandService;

    public CustomerController(CustomerQueryService customerQueryService, CustomerCommandService customerCommandService) {
        this.customerQueryService = customerQueryService;
        this.customerCommandService = customerCommandService;
    }

    @PostMapping
    public ResponseEntity<CustomerResource> createCustomer(@RequestBody CreateCustomerResource createCustomerResource) {
        var createCustomerCommand = CreateCustomerCommandFromResourceAssembler.toCommandResource(createCustomerResource);
        var customer = customerCommandService.handle(createCustomerCommand);
        if(customer.isEmpty()) return ResponseEntity.badRequest().build();

        var customerResource = CustomerResourceFromEntityAssembler.toResourceFromEntity(customer.get());
        return ResponseEntity.ok(customerResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResource> getCustomerById(@PathVariable Long id) {
        var getCustomerByIdQuery = new GetCustomerByIdQuery(id);
        var customer = customerQueryService.handle(getCustomerByIdQuery);
        if(customer.isEmpty()) return ResponseEntity.badRequest().build();
        var customerResource = CustomerResourceFromEntityAssembler.toResourceFromEntity(customer.get());
        return ResponseEntity.ok(customerResource);
    }
}
