package com.example.EasyFood.Orders.interfaces.rest.resources;

public record CreateLunchOrderResource(
        int quantity,
        int lunchId,
        int orderId
) {
}
