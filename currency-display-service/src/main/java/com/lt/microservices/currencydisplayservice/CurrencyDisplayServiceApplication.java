package com.lt.microservices.currencydisplayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class CurrencyDisplayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyDisplayServiceApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSample() {
		return Sampler.ALWAYS_SAMPLE;	
	}

}
