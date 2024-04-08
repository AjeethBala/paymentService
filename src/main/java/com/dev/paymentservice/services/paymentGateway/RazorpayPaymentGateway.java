package com.dev.paymentservice.services.paymentGateway;

import com.razorpay.PaymentLink;
import org.json.JSONObject;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentGateway{
    @Override
    public String generateLink() {
        try {
            RazorpayClient razorpay =
                    new RazorpayClient("rzp_test_eipCIIeZkZuiib", "bbNftuOZSpoVYpunddsiejzr");
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", 1000);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("accept_partial", false);
            paymentLinkRequest.put("first_min_partial_amount", 100);
            paymentLinkRequest.put("expire_by", 1711888104);
            paymentLinkRequest.put("reference_id", "TS1990");
            paymentLinkRequest.put("description", "Payment for policy no #23456");

            JSONObject customer = new JSONObject();
            customer.put("name", "+Ajeeth");
            customer.put("contact", "+918122338790");
            customer.put("email", "ajeethbala@gmail.com");
            paymentLinkRequest.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);
            paymentLinkRequest.put("notify", notify);

            paymentLinkRequest.put("callback_url", "https://google.com/");
            paymentLinkRequest.put("callback_method", "get");

            PaymentLink paymentLink = razorpay.paymentLink.create(paymentLinkRequest);
            return paymentLink.toString();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }
}

