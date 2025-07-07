package com.example.ordering.models;

import com.example.ordering.models.cart.CartId;
import com.example.ordering.models.paymentintent.PaymentIntentId;
import com.example.ordering.models.paymentintent.PaymentIntentStatus;
import com.example.ordering.models.paymentintent.PaymentMethod;

public record PaymentIntent(PaymentIntentId id, CartId cartId, PaymentMethod paymentMethod, PaymentIntentStatus status) {}
