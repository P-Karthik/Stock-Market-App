package com.wellsfargo.companydetailsservice.components;

import java.util.List;
import java.util.Optional;

import com.wellsfargo.companydetailsservice.models.StockExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockExchangeController {
    
    @Autowired
    private StockExchangeService stockExchangeService;

    @GetMapping(value = "/SE")
    public List<StockExchange> getAllStockExchange() {
        return stockExchangeService.getAllStockExchange();
    }

    @PostMapping(value = "/SE")
    public void addStockExchange(@RequestBody StockExchange stockExchange) {
        stockExchangeService.addStockExchange(stockExchange);
    }

    @PutMapping(value = "/SE/{id}")
    public void updateStockExchange(@RequestBody StockExchange stockExchange) {
        stockExchangeService.updateStockExchange(stockExchange);
    }

    @GetMapping(value = "/SE/{id}")
    public Optional<StockExchange> getStockExchangeyById(@PathVariable("id") Integer id) {
        return stockExchangeService.getStockExchangeById(id);
    }

    @DeleteMapping(value = "/SE/{id}")
    public void deleteStockExchange(@PathVariable("id") Integer id) {
        stockExchangeService.deleteStockExchange(id);
    }
    
}