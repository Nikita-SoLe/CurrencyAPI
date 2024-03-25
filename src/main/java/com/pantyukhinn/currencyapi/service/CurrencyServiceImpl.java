package com.pantyukhinn.currencyapi.service;

import com.pantyukhinn.currencyapi.model.Currency;
import com.pantyukhinn.currencyapi.repository.ParserCurrencyDAO;
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
    public Currency getCurrencyByName(String currency) {
        return dao.getCurrencyByName(currency);
    }

    @Override
    public Currency getCurrencyById(Integer id) {
        return dao.getCurrencyById(id);
    }

    @Override
    public Map<String, Currency> getSortedCurrencyNatural() {
        return dao.getSortedCurrencyNatural();
    }

    @Override
    public Map<String, Currency> getSortedCurrencyReverse() {
        return dao.getSortedCurrencyReverse();
    }

    @Override
    public Double convert(Integer id, Long value) {
        return dao.convert(id, value);
    }

    @Override
    public Boolean update() {
        return dao.update();
    }
}
