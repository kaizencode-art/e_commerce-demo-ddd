package com.example.ordering.port.in;

import com.example.ordering.models.cart.Address;
import com.example.ordering.models.cart.CartId;

public interface AddDeliveryAddressUseCase {
    void addDeliveryAddress(CartId carteId, Address shippingAddress);
}
