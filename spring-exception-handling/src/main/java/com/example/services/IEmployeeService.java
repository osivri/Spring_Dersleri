package com.example.services;

import com.example.dto.DtoEmployee;
import com.example.entities.Employee;

public interface IEmployeeService {
    public DtoEmployee findEmployeeById(Long id);
}
