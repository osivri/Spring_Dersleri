package com.example.services;

import com.example.dto.DtoAddress;
import com.example.dto.DtoAddressIU;

public interface IAddressService {
    public DtoAddress saveAddress(DtoAddressIU address);
}
