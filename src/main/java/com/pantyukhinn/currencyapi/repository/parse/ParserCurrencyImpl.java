package com.pantyukhinn.currencyapi.repository.parse;

import com.pantyukhinn.currencyapi.model.Currency;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ParserCurrencyImpl implements ParserCurrencyDAO {
    private Long time;
    private Map<String, Currency> map;

    @Override
    public Map<String, Currency> getAllCurrency() {
        return Parse.parse().stream().collect(Collectors.toMap(Currency::getName, obj -> obj));
    }

    @Override
    public Currency getCurrencyName(String currency) {
        return null;
    }

    @Override
    public Map<String, Currency> getSortedCurrencyNatural() {
        return null;
    }
}
