package com.example.controller;

import com.example.dto.DtoCar;
import com.example.dto.DtoCarIU;

public interface IRestCarController {
    public RootEntity<DtoCar> saveCar(DtoCarIU dtoCarIU);
}
