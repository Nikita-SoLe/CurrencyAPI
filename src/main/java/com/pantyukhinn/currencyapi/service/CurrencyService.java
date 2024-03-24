package com.pantyukhinn.currencyapi.service;

import com.pantyukhinn.currencyapi.model.Currency;

import java.util.Map;

public interface CurrencyService {
    Map<String, Currency> getAllCurrency();
    Currency getCurrencyName(String currency);
    Map<String, Currency> getSortedCurrencyNatural();
}
