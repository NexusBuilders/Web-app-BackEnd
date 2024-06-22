package com.example.EasyFood.Customers.interfaces.rest.resources;

public record CustomerResource(
        Long id,
        String firstName,
        String lastName,
        String email,
        String phone,
        int userId
) {
}
