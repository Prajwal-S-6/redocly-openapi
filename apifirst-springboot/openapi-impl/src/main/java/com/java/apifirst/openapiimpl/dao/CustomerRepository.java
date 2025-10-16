package com.java.apifirst.openapiimpl.dao;

import com.java.apifirst.model.GetAllCustomers200ResponseInner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<GetAllCustomers200ResponseInner, UUID> {
}
