package com.example.dto;

import com.example.enums.CarStatusType;
import com.example.enums.CurrencyType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DtoCar extends DtoBase{

    private String plaka;
    private String brand;
    private String model;
    private Integer productionYear;
    private BigDecimal price;
    private CurrencyType currencyType;
    private BigDecimal damagePrice;
    private CarStatusType carStatus;
}
