package com.lt.microservices.currencydisplayservice;

public class ExchangeValueObject extends ExchangeValue {

    private String childKey;

    public String getChildKey() {
        return childKey;
    }

    public void setChildKey(String childKey) {
        this.childKey = childKey;
    }
}
