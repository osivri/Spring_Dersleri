package com.example.dto;

import lombok.Data;

@Data
public class DtoUser extends DtoBase {
    private String username;
    private String password;
}
