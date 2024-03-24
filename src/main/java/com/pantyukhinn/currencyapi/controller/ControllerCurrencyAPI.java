package com.pantyukhinn.currencyapi.controller;

import com.pantyukhinn.currencyapi.model.Currency;
import com.pantyukhinn.currencyapi.service.CurrencyService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/currency")
public class ControllerCurrencyAPI {
    private final CurrencyService service;

    public ControllerCurrencyAPI(CurrencyService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public Map<String, Currency> getAllCurrency() {
        return service.getAllCurrency();
    }
}
