package com.lt.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyDisplayController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-display-feign-object/from/{from}/to/{to}")
    public CurrencyDisplayObjectBean currencyDisplayFeignObject(@PathVariable String from,
                                                                @PathVariable String to) {
        CurrencyDisplayObjectBean currencyDisplayObjectBean = new CurrencyDisplayObjectBean();
        currencyDisplayObjectBean.setFrom(from);
        currencyDisplayObjectBean.setTo(to);

        CurrencyDisplayObjectBean response = proxy.retrieveDisplayValueObject(from, to, currencyDisplayObjectBean);

        return response;
    }
}
