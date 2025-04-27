package com.example.starter;

import com.example.dto.DtoEmployee;
import com.example.services.IEmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {ExceptionManagementStarter.class})
class ExceptionManagementStarterTests {

    @Autowired
    private IEmployeeService employeeService;

    @BeforeEach
    public void beforeEach(){
        System.out.println("Before each test");
    }

    @Test
    public void testFindEmployeeById() {
        DtoEmployee dtoEmployee = employeeService.findEmployeeById(4L);
        assertNotNull(dtoEmployee);
        assertEquals(4,dtoEmployee.getId());
    }

    @AfterEach
    public void afterEach(){
        System.out.println("After each test");
    }

}
