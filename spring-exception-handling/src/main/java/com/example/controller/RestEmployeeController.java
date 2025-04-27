package com.example.controller;

import com.example.dto.DtoEmployee;
import com.example.entities.RootEntity;

public interface RestEmployeeController {
    public RootEntity<DtoEmployee> findEmployeeById(Long id);
}
