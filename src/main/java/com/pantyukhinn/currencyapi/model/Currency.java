package com.pantyukhinn.currencyapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Currency {
    private String name;
    private Integer  quantity;
    private Double currency;
    private String ost;
}
