package com.example.services;

import com.example.dto.DtoGalerist;
import com.example.dto.DtoGaleristIU;
import com.example.models.Gallerist;

public interface IGalleristService {

    public DtoGalerist saveGallerist(DtoGaleristIU dtoGaleristIU);
}
