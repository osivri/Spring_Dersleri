package com.example.config;

import com.example.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(1, "Oğuzhan", "Sivri"));
        employees.add(new Employee(2, "Elif", "Sivri"));
        employees.add(new Employee(3, "Mira Deniz", "Sivri"));
        employees.add(new Employee(4, "Tülin", "Sivri"));
        employees.add(new Employee(5, "Resul", "Sivri"));
        return employees;
    }
}
