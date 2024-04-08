package com.dev.paymentservice.services.paymentGateway;

import com.stripe.Stripe;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Source;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway{

    @Override
    public String generateLink() {
        Stripe.apiKey = "sk_test_51OyFtQSDizoVPuPa4OSqUSZFKuiCiwZ2cErWLNCJcwBDTIWtrETIwm36jce1x33DUkCeQTWqBW5tPTqZ04RAmitv003NklWPDp";

        try {
            PriceCreateParams priceParams =
                    PriceCreateParams.builder()
                            .setCurrency("inr")
                            .setUnitAmount(1000L)
                            .setRecurring(
                                    PriceCreateParams.Recurring.builder()
                                            .setInterval(PriceCreateParams.Recurring.Interval.MONTH)
                                            .build()
                            )
                            .setProductData(
                                    PriceCreateParams.ProductData.builder().setName("Gold Plan").build()
                            )
                            .build();

            Price price = Price.create(priceParams);
            PaymentLinkCreateParams params =
                    PaymentLinkCreateParams.builder()
                            .addLineItem(
                                    PaymentLinkCreateParams.LineItem.builder()
                                            .setPrice(price.getId())
                                            .setQuantity(1L)
                                            .build()
                            )
                            .build();

            PaymentLink paymentLink = PaymentLink.create(params);
            return paymentLink.toString();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return  null;



    }
}
