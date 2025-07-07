package com.example.ordering.models.cart;

public record CartId(long id) {
    public static CartId generate() {
        return new CartId(System.currentTimeMillis());
    }
}
