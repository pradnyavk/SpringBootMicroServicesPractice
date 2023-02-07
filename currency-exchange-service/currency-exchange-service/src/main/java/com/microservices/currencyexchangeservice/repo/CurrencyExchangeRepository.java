package com.microservices.currencyexchangeservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
	
	CurrencyExchange findByFromAndTo(String from, String to);

}
