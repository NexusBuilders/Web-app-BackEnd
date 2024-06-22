package com.example.EasyFood.Orders.interfaces.rest.resources;

public record CreateDrinkOrderResource(
        int quantity,
        int drinksId,
        int orderId
) {
}
