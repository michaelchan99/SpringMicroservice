package com.lt.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "netflix-zuul-api-gateway-server1")
@RibbonClient(name = "currency-display-service")
public interface CurrencyDisplayServiceProxy {

    @RequestMapping(value = "/currency-display-service/currency-display-object/from/{from}/to/{to}", method = RequestMethod.POST)
    CurrencyDisplayObjectBean retrieveDisplayValueObject(
            @PathVariable("from") String from, @PathVariable("to") String to, CurrencyDisplayObjectBean a);
}
