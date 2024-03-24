package com.pantyukhinn.currencyapi.repository.parse;

import com.pantyukhinn.currencyapi.model.Currency;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;


@Repository
public class ParserCurrencyImpl implements ParserCurrencyDAO {
    private Long time;
    private Map<String, Currency> map;

    @PostConstruct
    private void init() {
        this.time = System.currentTimeMillis();
        System.out.println("Время установлено на " + time);
        this.map = Parse.parse().stream().collect(Collectors.toMap(Currency::getName, obj -> obj));
        System.out.println("Мапа обновлена");
    }

    @Override
    public Map<String, Currency> getAllCurrency() {
        checkTime();
        return map;
    }

    @Override
    public Currency getCurrencyByName(String currency) {
        checkTime();
        return map.get(currency);
    }

    @Override
    public Currency getCurrencyById(Integer id) {
        checkTime();
        return map.values().stream()
                .filter(val -> id.equals(val.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Map<String, Currency> getSortedCurrencyNatural() {
        checkTime();
        return sortedNatural();
    }

    @Override
    public Map<String, Currency> getSortedCurrencyReverse() {
        checkTime();
        return sortedReverse();
    }

    @Override
    public Double convert(Integer id, Long value) {
        checkTime();
        Currency currency = getCurrencyById(id);
        return (currency.getCurrency() * value) * currency.getQuantity();
    }

    @Override
    public void update() {
        init();
    }

    private void checkTime() {
        if (System.currentTimeMillis() - time > 1000 * 60) {
            init();
        }
    }

    private Map<String, Currency> sortedNatural() {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Currency::getCurrency)))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) ->
                                        oldValue, LinkedHashMap::new));
    }

    private Map<String, Currency> sortedReverse() {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Currency::getCurrency).reversed()))
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) ->
                                        oldValue, LinkedHashMap::new));
    }
}
