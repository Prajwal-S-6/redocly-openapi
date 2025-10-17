package com.java.apifirst.openapiimpl.services;

import com.java.apifirst.model.GetAllProducts200ResponseInner;

public interface ProductsService {
    GetAllProducts200ResponseInner createProduct(GetAllProducts200ResponseInner product);
}
