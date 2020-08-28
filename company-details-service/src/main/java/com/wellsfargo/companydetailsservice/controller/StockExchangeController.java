package com.wellsfargo.companydetailsservice.controller;

import java.util.List;

import javax.transaction.Transactional;

import com.wellsfargo.companydetailsservice.models.StockExchange;
import com.wellsfargo.companydetailsservice.service.StockExchangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class StockExchangeController {
    
    @Autowired
    private StockExchangeService stockExchangeService;
    
    @Autowired
	private RestTemplate restTemplate;
	
    @GetMapping(value = "/se")
    public List<StockExchange> getAllStockExchanges() {
        return stockExchangeService.getAllStockExchanges();
    }

    @PostMapping(value = "/se/add")
    public void addStockExchange(@RequestBody StockExchange stockExchange) {
        stockExchangeService.addStockExchange(stockExchange);
    }

    @PutMapping(value = "/se/update")
    public void updateStockExchange(@RequestBody StockExchange stockExchange) {
        stockExchangeService.updateStockExchange(stockExchange);
    }
    
    @GetMapping(value = "/se/{id}")
    public StockExchange getStockExchangeyByName(@PathVariable int id) {
        return stockExchangeService.getStockExchangeById(id);
    }

    @GetMapping(value = "/se/{se_name}")
    public StockExchange getStockExchangeyByName(@PathVariable String se_name) {
        return stockExchangeService.getStockExchangeByName(se_name);
    }
    
    @Transactional
    @DeleteMapping(value = "/se/delete/{id}")
    public void deleteStockExchangeById(@PathVariable Integer id) {
        stockExchangeService.deleteStockExchangeById(id);
    }
    
    @Transactional
    @DeleteMapping(value = "/se/delete")
    public void deleteStockExchangeByName(@RequestBody String se_name) {
        stockExchangeService.deleteStockExchangeByName(se_name);
    }
    
}