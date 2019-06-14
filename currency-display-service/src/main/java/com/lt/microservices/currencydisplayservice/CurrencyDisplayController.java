package com.lt.microservices.currencydisplayservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class CurrencyDisplayController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @RequestMapping(value = "/currency-display-object/from/{from}/to/{to}", method = RequestMethod.POST)
    public ExchangeValueObject retrieveExchangeValueObject(@PathVariable String from, @PathVariable String to, MoneyPackageBean a) {
        ExchangeValueObject exchangeValueObject = new ExchangeValueObject();

        exchangeValueObject.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        try {
            exchangeValueObject.setServerName(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        exchangeValueObject.setFrom(from);
        exchangeValueObject.setId(111111L);
        exchangeValueObject.setTo(to);
        exchangeValueObject.setConversionMultiple(a.getAmount());
        exchangeValueObject.setChildKey("From: [" + from + "] To: [" + to + "]");
        logger.info("{}", exchangeValueObject);
        return exchangeValueObject;
    }
}
