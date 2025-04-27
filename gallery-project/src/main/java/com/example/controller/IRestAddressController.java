package com.example.controller;

import com.example.dto.DtoAddress;
import com.example.dto.DtoAddressIU;

public interface IRestAddressController {

    public RootEntity<DtoAddress> saveAddress(DtoAddressIU address);
}
