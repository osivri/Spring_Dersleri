package com.example.dto;

import com.example.enums.CarStatusType;
import com.example.enums.CurrencyType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DtoCarIU {

    @NotNull
    private String plaka;
    @NotNull

    private String brand;
    @NotNull

    private String model;
    @NotNull

    private Integer productionYear;
    @NotNull

    private BigDecimal price;
    @NotNull

    private CurrencyType currencyType;
    @NotNull

    private BigDecimal damagePrice;
    @NotNull

    private CarStatusType carStatus;
}
