package com.example.ordering.port.in;

import com.example.ordering.models.cart.CartId;
import com.example.ordering.models.cart.CustomerId;

public interface CreateCartUseCase {
    CartId createCart(CustomerId customerId);
}
