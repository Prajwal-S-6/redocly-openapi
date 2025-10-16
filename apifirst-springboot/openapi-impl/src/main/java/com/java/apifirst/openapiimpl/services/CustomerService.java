package com.java.apifirst.openapiimpl.services;

import com.java.apifirst.model.GetAllCustomers200ResponseInner;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<GetAllCustomers200ResponseInner> getAllCustomers();

    GetAllCustomers200ResponseInner getCustomerById(UUID id);
}
