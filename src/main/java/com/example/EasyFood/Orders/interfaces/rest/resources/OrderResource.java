package com.example.EasyFood.Orders.interfaces.rest.resources;

public record OrderResource(Long id,
                            String address,
                            String arriveTime,
                            Number totalAmount) {
}
