package com.example.services;

import com.example.model.Employee;
import com.example.model.UpdateEmployeeRequest;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    public  List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    public boolean deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
        return true;
    }

    public Employee updateEmployee(int id, UpdateEmployeeRequest employee) {
        return employeeRepository.updateEmployee(id, employee);
    }
}
