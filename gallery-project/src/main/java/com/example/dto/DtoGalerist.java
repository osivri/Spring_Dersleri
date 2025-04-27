package com.example.dto;

import lombok.Data;

@Data
public class DtoGalerist extends DtoBase{
    private String firstName;
    private String lastName;
    private DtoAddress address;
}
