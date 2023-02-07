package com.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.currencyexchangeservice.bean.CurrencyExchange;
import com.microservices.currencyexchangeservice.repo.CurrencyExchangeRepository;
import java.lang.RuntimeException;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		String port = env.getProperty("server.port");
//		CurrencyExchange currencyExchange = new CurrencyExchange(1000L,from, to, BigDecimal.valueOf(50));
		CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException("Unable to find data for "+from+" to "+ to);
		}
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
	}
	

}
