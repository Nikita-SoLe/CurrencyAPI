package com.pantyukhinn.currencyapi.repository.parse;

import java.util.Map;
import com.pantyukhinn.currencyapi.model.Currency;

public interface ParserCurrencyDAO {
    Map<String, Currency> getAllCurrency();

    Currency getCurrencyName(String currency);

    Map<String, Currency> getSortedCurrencyNatural();
}