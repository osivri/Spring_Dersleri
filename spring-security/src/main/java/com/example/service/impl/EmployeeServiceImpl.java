package com.example.service.impl;

import com.example.dto.DtoDepartment;
import com.example.dto.DtoEmployee;
import com.example.models.Department;
import com.example.models.Employee;
import com.example.reposiitory.EmployeeRepository;
import com.example.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee findEmployeeById(Long id) {
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment departmentDto = new DtoDepartment();
        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Employee employee = optional.get();
        Department department = employee.getDepartment();
        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, departmentDto);
        dtoEmployee.setDepartmentDto(departmentDto);
        return dtoEmployee;
    }
}
