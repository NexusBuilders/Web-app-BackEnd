package com.example.EasyFood.Orders.interfaces.rest.resources;

public record DrinkOrderResource(Long id,
                                 int quantity,
                                 int drinksId,
                                 int orderId) {
}
