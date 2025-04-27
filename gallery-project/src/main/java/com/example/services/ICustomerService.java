package com.example.services;

import com.example.dto.DtoCustomer;
import com.example.dto.DtoCustomerIU;

public interface ICustomerService {
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
