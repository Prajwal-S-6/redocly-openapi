package com.java.apifirst.openapiimpl.services;

import com.java.apifirst.model.GetAllCustomers200ResponseInner;
import com.java.apifirst.model.GetAllProducts200ResponseInner;

import java.util.List;

public interface ProductsService {
    GetAllProducts200ResponseInner createProduct(GetAllProducts200ResponseInner product);

    List<GetAllProducts200ResponseInner> getAllProducts();
}
