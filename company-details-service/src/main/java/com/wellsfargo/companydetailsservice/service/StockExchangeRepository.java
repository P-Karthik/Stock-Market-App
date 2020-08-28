package com.wellsfargo.companydetailsservice.service;

import org.springframework.data.repository.CrudRepository;

import com.wellsfargo.companydetailsservice.models.StockExchange;

public interface StockExchangeRepository extends CrudRepository<StockExchange, Integer>{

	StockExchange findBySeName(String se_name);
	void deleteBySeName(String se_name);
}