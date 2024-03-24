package com.pantyukhinn.currencyapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class Currency {
    private Integer id;
    private String name;
    private Integer  quantity;
    private Double currency;
    private String ost;
}
