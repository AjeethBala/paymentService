package com.dev.paymentservice.services;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGatewayChooserStrategy paymentGatewayChooserStrategy;
    public PaymentService(PaymentGatewayChooserStrategy paymentGatewayChooserStrategy){
        this.paymentGatewayChooserStrategy=paymentGatewayChooserStrategy;
    }

    public String initiatePayment(){
        return paymentGatewayChooserStrategy
                .getBestPaymetGateway()
                .generateLink();
    }
}

