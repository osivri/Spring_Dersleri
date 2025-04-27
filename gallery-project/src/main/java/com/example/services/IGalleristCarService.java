package com.example.services;

import com.example.dto.DtoGalleristCar;
import com.example.dto.DtoGalleristCarIU;
import com.example.models.GalleristCar;

public interface IGalleristCarService {
    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU galleristCar);
}
