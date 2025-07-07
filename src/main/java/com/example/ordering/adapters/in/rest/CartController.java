package com.example.ordering.adapters.in.rest;

import com.example.ordering.adapters.in.rest.dto.cart.CreateCartRequest;
import com.example.ordering.models.cart.CustomerId;
import com.example.ordering.port.in.CreateCartUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CreateCartUseCase createCartUseCase;

    public CartController(CreateCartUseCase createCartUseCase) {
        this.createCartUseCase = createCartUseCase;
    }

    @PostMapping
    public ResponseEntity<String> createCart(@RequestBody CreateCartRequest request) {
        var customerId = new CustomerId(request.customerId());
        var cartId = createCartUseCase.createCart(customerId);
        return ResponseEntity.status(201).body(String.valueOf(cartId.id()));
    }
}
