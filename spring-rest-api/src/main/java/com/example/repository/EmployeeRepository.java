package com.example.repository;

import com.example.model.Employee;
import com.example.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employees;

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee findEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeWithParams = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return employees;
        }
        for (Employee employee : employees) {
            if (firstName != null && lastName != null){
                if (employee.getFirstName().equalsIgnoreCase(firstName) && employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            }
            if (firstName != null && lastName == null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)){
                    employeeWithParams.add(employee);
                }
            }
            if (firstName == null && lastName != null) {
                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeWithParams.add(employee);
                }
            }
        }
        return employeeWithParams;
    }

    public Employee saveEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public boolean deleteEmployee(int id) {
        Employee deleteEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                deleteEmployee = employee;
                break;
            }
        }
        if (deleteEmployee == null) {
            return false;
        }
        employees.remove(deleteEmployee);
        return true;
    }

    private Employee findEmployeeById(int id) {
        Employee findEmployee = null;
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public Employee updateEmployee(int id, UpdateEmployeeRequest employee) {
        Employee findEmployee = findEmployeeById(id);
        if (findEmployee != null) {
            deleteEmployee(id);
            Employee updatedEmployee = new Employee();
            updatedEmployee.setId(id);
            updatedEmployee.setFirstName(employee.getFirstName());
            updatedEmployee.setLastName(employee.getLastName());
            employees.add(updatedEmployee);
            return updatedEmployee;
        }
        return null;
    }
}
