package com.dev.paymentservice.services;

import com.dev.paymentservice.services.paymentGateway.PaymentGateway;
import com.dev.paymentservice.services.paymentGateway.RazorpayPaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayChooserStrategy {
    private RazorpayPaymentGateway razorpayPaymentGateway;

    public PaymentGatewayChooserStrategy(RazorpayPaymentGateway razorpayPaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
    }


    public PaymentGateway getBestPaymetGateway(){
        //write some logics to choose payment gaweway
        return razorpayPaymentGateway;
    }
}
