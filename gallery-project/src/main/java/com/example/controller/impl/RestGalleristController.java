package com.example.controller.impl;

import com.example.controller.IRestGalleristController;
import com.example.controller.RestBaseController;
import com.example.controller.RootEntity;
import com.example.dto.DtoGalerist;
import com.example.dto.DtoGaleristIU;
import com.example.services.IGalleristService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/gallerist")
public class RestGalleristController extends RestBaseController implements IRestGalleristController {

    @Autowired
    private IGalleristService galleristService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGalerist> saveGallerist(@Valid @RequestBody DtoGaleristIU dtoGaleristIU) {
        return ok(galleristService.saveGallerist(dtoGaleristIU));
    }
}
