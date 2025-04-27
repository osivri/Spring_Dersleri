package com.example.services;

import com.example.dto.DtoCar;
import com.example.dto.DtoCarIU;

public interface ICarService {
    public DtoCar saveCar(DtoCarIU dtoCarIU);
}
