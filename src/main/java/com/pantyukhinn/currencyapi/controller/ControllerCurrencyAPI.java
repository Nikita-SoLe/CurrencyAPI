package com.pantyukhinn.currencyapi.controller;

import com.pantyukhinn.currencyapi.model.Currency;
import com.pantyukhinn.currencyapi.service.CurrencyService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/getByName/{name}")
    public Currency getCurrency(@PathVariable String name) {
        return service.getCurrencyByName(name);
    }

    @GetMapping("/sortedNatural")
    public Map<String, Currency> getSortedCurrencyNatural() {
        return service.getSortedCurrencyNatural();
    }

    @GetMapping("/sortedReverse")
    public Map<String, Currency> getSortedCurrencyReverse() {
        return service.getSortedCurrencyReverse();
    }

    @GetMapping("/convert/{id}/{value}")
    public Double convert(@PathVariable Integer id, @PathVariable Long value) {
        return service.convert(id, value);
    }
    @GetMapping("/getById/{id}")
    public Currency getCurrencyById(@PathVariable Integer id) {
        return service.getCurrencyById(id);
    }

    @GetMapping("/update")
    public String update() {
        service.update();
        return "Updated";
    }
}
