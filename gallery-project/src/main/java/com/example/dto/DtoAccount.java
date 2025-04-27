package com.example.dto;

import com.example.enums.CurrencyType;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DtoAccount extends DtoBase {


    private String accountNo;


    private String iban;


    private BigDecimal amount;


    private CurrencyType currencyType;
}
