package com.example.ordering.adapters.in.rest.dto.cart;


public class CreateCartRequest {

    private long customerId;

    public CreateCartRequest() {}

    public CreateCartRequest(long customerId) {
        this.customerId = customerId;
    }

    public long customerId() {
        return customerId;
    }
}
