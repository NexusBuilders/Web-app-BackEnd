package com.example.EasyFood.Orders.interfaces.rest.resources;

public record LunchOrderResource(Long id,
                                 int quantity,
                                 int drinksId,
                                 int orderId) {
}
