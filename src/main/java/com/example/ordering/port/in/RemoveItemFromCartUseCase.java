package com.example.ordering.port.in;

import com.example.ordering.models.cart.CartId;
import com.example.ordering.models.cart.Product;

public interface RemoveItemFromCartUseCase {
    void removeItemFromCart(CartId cartId, Product product);
}
