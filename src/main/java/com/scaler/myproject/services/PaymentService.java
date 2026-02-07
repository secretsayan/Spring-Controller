package com.scaler.myproject.services;

import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(Long orderId) throws StripeException {
        //Order Details
        //Make a call to Payment Gateway (Razorpay or Stripe) to generate the payment link.
        return paymentGateway.initiatePayment(orderId);
    }
}
