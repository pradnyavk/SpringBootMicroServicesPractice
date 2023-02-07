package com.microservices.currencyexchangeservice.bean;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CurrencyExchange {
	
	@Id
	private Long id;
	@Column(name="currency_to")
	private String to;
	@Column(name="currency_from")
	private String from;
	private BigDecimal conversionMultiple;
	//to get which instance of currency exchange service we want
	private String environment;
	
	
	public CurrencyExchange() {
		super();
	}
	public CurrencyExchange(Long id, String to, String from, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.to = to;
		this.from = from;
		this.conversionMultiple = conversionMultiple;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	
	
	

}
