package com.example.ordering.port.in;

import com.example.ordering.models.paymentintent.PaymentMethod;
import com.example.ordering.models.cart.CartId;
import com.example.ordering.models.paymentintent.PaymentIntentId;

public interface InitiatePaymentUseCase {
    PaymentIntentId initiatePayment(CartId cartId, PaymentMethod paymentMethod);
}
