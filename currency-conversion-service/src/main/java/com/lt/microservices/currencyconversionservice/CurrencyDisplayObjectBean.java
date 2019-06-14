package com.lt.microservices.currencyconversionservice;

import lombok.Data;

@Data
public class CurrencyDisplayObjectBean {
    private Long id;
    private String from;
    private String to;
    private String message;
    private int port;
    private String serverName;
}
