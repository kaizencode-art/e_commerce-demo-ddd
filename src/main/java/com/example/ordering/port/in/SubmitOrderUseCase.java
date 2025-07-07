package com.example.ordering.port.in;

import com.example.ordering.models.cart.CartId;

public interface SubmitOrderUseCase {
    void submitOrder(CartId cartId);
}
