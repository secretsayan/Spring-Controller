package com.scaler.myproject.paymentgateways;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String initiatePayment(Long orderId) throws StripeException;
}
