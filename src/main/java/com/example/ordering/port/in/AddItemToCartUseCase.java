package com.example.ordering.port.in;

import com.example.ordering.models.cart.CartId;
import com.example.ordering.models.cart.Product;

public interface AddItemToCartUseCase {
    void addItemToCart(CartId cartId, Product product);
}
