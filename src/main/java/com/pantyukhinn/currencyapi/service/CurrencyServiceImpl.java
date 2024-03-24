package com.pantyukhinn.currencyapi.service;

import com.pantyukhinn.currencyapi.model.Currency;
import com.pantyukhinn.currencyapi.repository.parse.Parse;
import com.pantyukhinn.currencyapi.repository.parse.ParserCurrencyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final ParserCurrencyDAO dao;

    public CurrencyServiceImpl(ParserCurrencyDAO dao) {
        this.dao = dao;
    }

    @Override
    public Map<String, Currency> getAllCurrency() {
        return dao.getAllCurrency();
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
