package com.example.services;


import com.example.dto.DtoAddress;

public interface IAddressService {
    public DtoAddress findById(Long id);
}
