package com.example.ordering.service;

import com.example.ordering.models.Cart;
import com.example.ordering.models.cart.Address;
import com.example.ordering.models.cart.CartId;
import com.example.ordering.port.in.AddDeliveryAddressUseCase;
import com.example.ordering.port.out.CartPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class AddDeliveryAddressService implements AddDeliveryAddressUseCase {

    private final CartPersistencePort cartPort;

    public AddDeliveryAddressService(CartPersistencePort cartPort) {
        this.cartPort = cartPort;
    }

    @Override
    public void addDeliveryAddress(CartId carteId, Address shippingAdresse) {
        Cart cart = cartPort.findById(carteId)
                .orElseThrow(() -> new IllegalArgumentException("CartEntity not found"));
        Cart updatedCart = cart.withShippingAddress(shippingAdresse);
        cartPort.save(updatedCart);
    }
}
