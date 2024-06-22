package com.example.EasyFood.Orders.interfaces.rest.resources;

public record CreateOrderResource(String address,
                                  String arriveTime,
                                  Double totalAmount,
                                  int customerId) {
}
