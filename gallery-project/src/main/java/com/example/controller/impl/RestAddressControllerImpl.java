package com.example.controller.impl;

import com.example.controller.IRestAddressController;
import com.example.controller.RootEntity;
import com.example.dto.DtoAddress;
import com.example.dto.DtoAddressIU;
import com.example.services.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.controller.RootEntity.ok;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressControllerImpl implements IRestAddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU address) {
        return ok(addressService.saveAddress(address));
    }
}
