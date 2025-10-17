package com.java.apifirst.openapiimpl.services;

import com.java.apifirst.model.GetAllProducts200ResponseInner;
import com.java.apifirst.openapiimpl.dao.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {
    private final ProductRepository productRepository;
    @Override
    public GetAllProducts200ResponseInner createProduct(GetAllProducts200ResponseInner product) {
        return productRepository.save(product);
    }
}
