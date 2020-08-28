package com.wellsfargo.companydetailsservice.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.wellsfargo.companydetailsservice.models.StockExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockExchangeService {

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    List<StockExchange> se = new ArrayList<>();
	public List<StockExchange> getAllStockExchange() {
		stockExchangeRepository.findAll().forEach(se::add);
        return se;
	}

	public void addStockExchange(StockExchange stockExchange) {
        stockExchangeRepository.save(stockExchange);
	}

	public void updateStockExchange(StockExchange stockExchange) {
        stockExchangeRepository.save(stockExchange);
	}

	public Optional<StockExchange> getStockExchangeById(Integer id) {
		return stockExchangeRepository.findById(id);
	}

	public void deleteStockExchange(Integer id) {
        stockExchangeRepository.deleteById(id);
	}

}
