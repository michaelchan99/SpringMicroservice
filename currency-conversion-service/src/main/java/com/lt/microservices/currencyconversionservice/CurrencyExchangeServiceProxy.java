package com.lt.microservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClients(
        value = {
                @RibbonClient(name = "currency-exchange-service"),
                @RibbonClient(name = "currency-display-service")
        })
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionBean retrieveExchangeValue(
            @PathVariable("from") String from, @PathVariable("to") String to);

    @RequestMapping(value = "/currency-exchange-service/currency-exchange-object/from/{from}/to/{to}", method = RequestMethod.POST)
    CurrencyConversionObjectBean retrieveExchangeValueObject(
            @PathVariable("from") String from, @PathVariable("to") String to, MoneyPackageBean a);

    @RequestMapping(value = "/currency-display-service/currency-display-object/from/{from}/to/{to}", method = RequestMethod.POST)
    CurrencyDisplayObjectBean retrieveDisplayValueObject(
            @PathVariable("from") String from, @PathVariable("to") String to, CurrencyDisplayObjectBean a);
}
