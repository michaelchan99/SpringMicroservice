package com.lt.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class CurrencyExchangeController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
//		ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));

		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		try {
			exchangeValue.setServerName(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		logger.info("{}", exchangeValue);
		return exchangeValue;
	}

	@RequestMapping(value = "/currency-exchange-object/from/{from}/to/{to}", method = RequestMethod.POST)
	public ExchangeValueObject retrieveExchangeValueObject(@PathVariable String from, @PathVariable String to, MoneyPackageBean a) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);

		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		try {
			exchangeValue.setServerName(InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		ExchangeValueObject exchangeValueObject = new ExchangeValueObject();
        exchangeValueObject.setFrom(exchangeValue.getFrom());
        exchangeValueObject.setId(exchangeValue.getId());
        exchangeValueObject.setPort(exchangeValue.getPort());
        exchangeValueObject.setServerName(exchangeValue.getServerName());
        exchangeValueObject.setTo(exchangeValue.getTo());
        exchangeValueObject.setConversionMultiple(exchangeValue.getConversionMultiple());
		exchangeValueObject.setChildKey("From: [" + exchangeValue.getFrom() + "] To: [" + exchangeValue.getTo() + "]");
		logger.info("{}", exchangeValueObject);
		return exchangeValueObject;
	}
}
