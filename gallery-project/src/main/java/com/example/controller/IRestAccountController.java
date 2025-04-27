package com.example.controller;

import com.example.dto.DtoAccount;
import com.example.dto.DtoAccountIU;

public interface IRestAccountController {
    public RootEntity<DtoAccount> saveAccount(DtoAccountIU accountIU);
}
