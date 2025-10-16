package com.java.apifirst.openapiimpl.controllers;

import com.java.apifirst.model.GetAllCustomers200ResponseInner;
import com.java.apifirst.openapiimpl.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/v1/customers")
    public List<GetAllCustomers200ResponseInner> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/v1/customer/{id}")
    public GetAllCustomers200ResponseInner getCustomerById(@PathVariable("id") UUID id) {
        return customerService.getCustomerById(id);
    }
}
