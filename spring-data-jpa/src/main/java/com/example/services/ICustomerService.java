package com.example.services;

import com.example.dto.DtoCustomer;

public interface ICustomerService {
    public DtoCustomer findByCustomerId(Long customerId);
}
