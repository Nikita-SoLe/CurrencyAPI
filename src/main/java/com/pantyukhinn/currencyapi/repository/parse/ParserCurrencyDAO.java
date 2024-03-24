package com.pantyukhinn.currencyapi.repository.parse;

import java.util.Map;
import com.pantyukhinn.currencyapi.model.Currency;

public interface ParserCurrencyDAO {
    Map<String, Currency> getAllCurrency();

    Currency getCurrencyByName(String currency);

    Currency getCurrencyById(Integer id);

    Map<String, Currency> getSortedCurrencyNatural();

    Map<String, Currency> getSortedCurrencyReverse();

    Double convert(Integer id, Long value);

    void update();
}