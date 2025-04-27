package com.example.dto;

import lombok.Data;

@Data
public class DtoGalleristCar extends DtoBase{
    private DtoGalerist gallerist;
    private DtoCar car;
}
