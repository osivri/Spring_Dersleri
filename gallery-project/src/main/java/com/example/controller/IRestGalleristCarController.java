package com.example.controller;

import com.example.dto.DtoGalleristCar;
import com.example.dto.DtoGalleristCarIU;

public interface IRestGalleristCarController {
    public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU galleristCar);
}
