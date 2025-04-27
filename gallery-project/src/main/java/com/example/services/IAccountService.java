package com.example.services;

import com.example.dto.DtoAccount;
import com.example.dto.DtoAccountIU;

public interface IAccountService {
    public DtoAccount saveAccount(DtoAccountIU accountIU);
}
