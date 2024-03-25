package com.pantyukhinn.currencyapi.service;

import com.pantyukhinn.currencyapi.model.Currency;

import java.util.Map;

public interface CurrencyService {
    Map<String, Currency> getAllCurrency();
    Currency getCurrencyByName(String currency);
    Currency getCurrencyById(Integer id);
    Map<String, Currency> getSortedCurrencyNatural();
    Map<String, Currency> getSortedCurrencyReverse();
    Double convert(Integer id, Long value);
    Boolean update();
}
