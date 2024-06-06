package com.example.EasyFood.easyfood.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Quantity(int value) {
    public Quantity {
        if (value < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }

    public int increment(int amount) {
        return value + amount;
    }

    public int decrement(int amount) {
        if (value - amount < 0) {
            throw new IllegalArgumentException("Resulting quantity cannot be negative");
        }
        return value - amount;
    }
}
