package com.example.controller;

import com.example.dto.DtoEmployee;

public interface IRestEmployeeController {
    public DtoEmployee findEmployeeById(Long id);
}
