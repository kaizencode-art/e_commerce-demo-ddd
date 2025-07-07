package com.example.ordering.port.out;

import com.example.ordering.models.PaymentIntent;

import java.util.Optional;

public interface PaymentIntentPort {
    void save(PaymentIntent paymentIntent);
    Optional<PaymentIntent> findById(String id);
}
