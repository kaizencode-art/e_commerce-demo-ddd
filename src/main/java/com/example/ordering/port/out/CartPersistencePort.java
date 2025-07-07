package com.example.ordering.port.out;

import com.example.ordering.models.Cart;
import com.example.ordering.models.cart.CartId;

import java.util.Optional;

public interface CartPersistencePort {
    Optional<Cart> findById(CartId cartId);
    void save(Cart cart);
    void delete(CartId cartId);
}
