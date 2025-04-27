package com.example.controller.impl;

import com.example.controller.ICustomerController;
import com.example.dto.DtoCustomer;
import com.example.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/api/customer")
public class CustomerControllerImpl implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list/{id}")
    @Override
    public DtoCustomer findByCustomerId(@PathVariable(name = "id") Long customerId) {
        return customerService.findByCustomerId(customerId);
    }
}
