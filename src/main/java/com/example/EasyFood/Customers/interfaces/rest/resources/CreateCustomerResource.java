package com.example.EasyFood.Customers.interfaces.rest.resources;

public record CreateCustomerResource(
        String firstName,
        String lastName,
        String email,
        String phone,
        int userId
) {
}
