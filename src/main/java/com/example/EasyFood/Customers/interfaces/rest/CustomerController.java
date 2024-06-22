package com.example.EasyFood.Customers.interfaces.rest;

import com.example.EasyFood.Customers.domain.model.commands.UpdateCustomerCommand;
import com.example.EasyFood.Customers.domain.model.queries.GetCustomerByIdQuery;
import com.example.EasyFood.Customers.domain.model.queries.GetCustomerByUserIdQuery;
import com.example.EasyFood.Customers.domain.service.CustomerCommandService;
import com.example.EasyFood.Customers.domain.service.CustomerQueryService;
import com.example.EasyFood.Customers.interfaces.rest.resources.CreateCustomerResource;
import com.example.EasyFood.Customers.interfaces.rest.resources.CustomerResource;
import com.example.EasyFood.Customers.interfaces.rest.transform.CreateCustomerCommandFromResourceAssembler;
import com.example.EasyFood.Customers.interfaces.rest.transform.CustomerResourceFromEntityAssembler;
import com.example.EasyFood.Menus.domain.model.commands.UpdateLunchCommand;
import com.example.EasyFood.Menus.domain.model.queries.GetDrinksByRestaurantId;
import com.example.EasyFood.Menus.interfaces.rest.resources.CreateLunchResource;
import com.example.EasyFood.Menus.interfaces.rest.resources.DrinkResource;
import com.example.EasyFood.Menus.interfaces.rest.resources.LunchResource;
import com.example.EasyFood.Menus.interfaces.rest.transform.DrinkResourceFromEntityAssembler;
import com.example.EasyFood.Menus.interfaces.rest.transform.LunchResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CustomerResource>> getCustomerByUserId(@PathVariable Long userId) {
        var getCustomerByIdRestaurant = new GetCustomerByUserIdQuery(userId);
        var customer = customerQueryService.handle(getCustomerByIdRestaurant);
        var customerResources = customer.stream()
                .map(CustomerResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerResources);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResource> updateCustomer(@PathVariable Long id, @RequestBody CreateCustomerResource resource) {
        var updateCustomerCommand = new UpdateCustomerCommand(id, resource.firstName(), resource.lastName(), resource.email(), resource.phone());
        var customer = customerCommandService.handle(updateCustomerCommand);
        if(customer.isEmpty()) return ResponseEntity.badRequest().build();

        var customerResource = CustomerResourceFromEntityAssembler.toResourceFromEntity(customer.get());
        return ResponseEntity.ok(customerResource);
    }
}
