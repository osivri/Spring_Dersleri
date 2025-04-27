package com.example.services.impl;

import com.example.dto.DtoAccount;
import com.example.dto.DtoAccountIU;
import com.example.models.Account;
import com.example.repository.AccountRepository;
import com.example.services.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    private Account createAccount(DtoAccountIU accountIU) {
        Account account = new Account();
        account.setCreatedAt(new Date());
        BeanUtils.copyProperties(accountIU, account);
        return account;
    }

    @Override
    public DtoAccount saveAccount(DtoAccountIU accountIU) {
        DtoAccount dtoAccount = new DtoAccount();
        Account account = accountRepository.save(createAccount(accountIU));
        BeanUtils.copyProperties(account, dtoAccount);
        return dtoAccount;
    }
}
