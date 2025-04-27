package com.example.dto;

import com.example.models.Account;
import com.example.models.Address;
import lombok.Data;

import java.util.Date;

@Data
public class DtoCustomer extends DtoBase{
    private String firstName;
    private String lastName;
    private String tckn;
    private Date birthOfDate;
    private DtoAddress address;
    private DtoAccount account;
}
