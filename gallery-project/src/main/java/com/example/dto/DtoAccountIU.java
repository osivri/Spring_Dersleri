package com.example.dto;

import com.example.enums.CurrencyType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DtoAccountIU {

    @NotEmpty
    private String accountNo;

    @NotEmpty
    private String iban;


    private BigDecimal amount;


    private CurrencyType currencyType;
}
