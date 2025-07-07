package com.example.ordering.models.cart;

public record Price(int amount) {
    public Price {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
    }
}
