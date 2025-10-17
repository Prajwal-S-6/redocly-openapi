package com.java.apifirst.openapiimpl.dao;

import com.java.apifirst.model.GetAllProducts200ResponseInner;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepository extends CrudRepository<GetAllProducts200ResponseInner, UUID> {
}
