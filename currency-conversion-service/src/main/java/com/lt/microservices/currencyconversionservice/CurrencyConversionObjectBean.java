package com.lt.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionObjectBean extends CurrencyConversionBean {
    private Object childKey;

    public CurrencyConversionObjectBean() {

    }

    public CurrencyConversionObjectBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity, BigDecimal totalCalculatedAmount, int port, String serverName, Object childKey) {
        super(id, from, to, conversionMultiple, quantity, totalCalculatedAmount, port, serverName);
        this.childKey = childKey;
    }

    public Object getChildKey() {
        return childKey;
    }

    public void setChildKey(Object childKey) {
        this.childKey = childKey;
    }
}
