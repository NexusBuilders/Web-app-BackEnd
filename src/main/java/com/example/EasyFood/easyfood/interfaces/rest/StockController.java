package com.example.EasyFood.easyfood.interfaces.rest;

import com.example.EasyFood.easyfood.application.services.StockApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    private final StockApplicationService stockApplicationService;

    public StockController(StockApplicationService stockApplicationService) {
        this.stockApplicationService = stockApplicationService;
    }

    @GetMapping
    public String getStock() {
        return stockApplicationService.getStockDetails();
    }



}
