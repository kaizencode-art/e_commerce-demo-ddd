package com.example.ordering.service;

import com.example.ordering.models.Cart;
import com.example.ordering.models.cart.CartId;
import com.example.ordering.models.cart.CustomerId;
import com.example.ordering.port.in.CreateCartUseCase;
import com.example.ordering.port.out.CartPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class CreateCartService implements CreateCartUseCase {

    private final CartPersistencePort cartPort;

    public CreateCartService(CartPersistencePort cartPort) {
        this.cartPort = cartPort;
    }

    @Override
    public CartId createCart(CustomerId customerId) {
        Cart cart = Cart.createCart(customerId);
        cartPort.save(cart);
        return cart.id();
    }
}
