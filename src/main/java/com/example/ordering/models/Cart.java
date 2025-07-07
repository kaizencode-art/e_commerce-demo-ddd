package com.example.ordering.models;

import com.example.ordering.models.cart.*;

import java.util.List;

public record Cart(CartId id, List<Product> products, CartStatus status, Address shippingAddress, Price totalPrice) {

    public static Cart createCart(CustomerId customerId) {
        return new Cart(CartId.generate(), List.of(), CartStatus.DRAFT, null, null);
    }

    public Cart withShippingAddress(Address shippingAddress) {
        return new Cart(id, products, status, shippingAddress, totalPrice);
    }
}