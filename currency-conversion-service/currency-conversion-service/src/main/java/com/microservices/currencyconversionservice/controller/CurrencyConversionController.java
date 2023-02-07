package com.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservices.currencyconversionservice.bean.CurrencyConversion;
import com.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currExchangeProxy;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
//		HashMap<String,String> uriVariables = new HashMap<String, String>();
//		uriVariables.put("from", from);
//		uriVariables.put("to", to);
//		//to make rest api call 
//		
//		
//		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class,uriVariables);
//		
//		CurrencyConversion currConversion =  responseEntity.getBody();
//		currConversion.setQuantity(quantity);
//		currConversion.setTotalCalculatedAmount(quantity.multiply(currConversion.getConversionMultiple()));
//		
		CurrencyConversion currConversion =  currExchangeProxy.retrieveExchangeValue(from, to);
		currConversion.setQuantity(quantity);
		currConversion.setTotalCalculatedAmount(quantity.multiply(currConversion.getConversionMultiple()));
		
		return currConversion;
	}

}
