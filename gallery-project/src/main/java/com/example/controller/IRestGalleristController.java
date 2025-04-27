package com.example.controller;

import com.example.dto.DtoGalerist;
import com.example.dto.DtoGaleristIU;

public interface IRestGalleristController {
    public RootEntity<DtoGalerist> saveGallerist(DtoGaleristIU dtoGaleristIU);
}
