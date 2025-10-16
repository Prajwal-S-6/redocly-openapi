package com.java.apifirst.openapiimpl.services;

import com.java.apifirst.model.GetAllCustomers200ResponseInner;
import com.java.apifirst.openapiimpl.dao.CustomerRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositoryImpl customerRepository;

    @Override
    public List<GetAllCustomers200ResponseInner> getAllCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public GetAllCustomers200ResponseInner getCustomerById(UUID id) {
        return customerRepository.findById(id).orElseThrow();
    }


}
