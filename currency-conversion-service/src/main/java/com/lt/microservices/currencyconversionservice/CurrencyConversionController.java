package com.lt.microservices.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from,
                                                  @PathVariable String to,
                                                  @PathVariable BigDecimal quantity) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversionBean> responseEntity =
                new RestTemplate().getForEntity(
                        "http://currency-exchange-service:8000/currency-exchange/from/{from}/to/{to}",
                        CurrencyConversionBean.class, uriVariables);
        CurrencyConversionBean response = responseEntity.getBody();

        return new CurrencyConversionBean(response.getId(), from, to,
                response.getConversionMultiple(),
                quantity, quantity.multiply(response.getConversionMultiple()),
                response.getPort(), response.getServerName());
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from,
                                                       @PathVariable String to,
                                                       @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

        return new CurrencyConversionBean(response.getId(), from, to,
                response.getConversionMultiple(),
                quantity, quantity.multiply(response.getConversionMultiple()),
                response.getPort(), response.getServerName());
    }

    @GetMapping("/currency-converter-feign-object/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionObjectBean convertCurrencyFeignObject(@PathVariable String from,
                                                                   @PathVariable String to,
                                                                   @PathVariable BigDecimal quantity) {
        MoneyPackageBean moneyPackageBean = new MoneyPackageBean();
        moneyPackageBean.setAmount(quantity);
        moneyPackageBean.setCurrencyFrom(from);
        moneyPackageBean.setCurrencyTo(to);

        CurrencyConversionObjectBean response = proxy.retrieveExchangeValueObject(from, to, moneyPackageBean);

        return new CurrencyConversionObjectBean(response.getId(), from, to,
                response.getConversionMultiple(),
                quantity, quantity.multiply(response.getConversionMultiple()),
                response.getPort(), response.getServerName(), response.getChildKey());
    }
}