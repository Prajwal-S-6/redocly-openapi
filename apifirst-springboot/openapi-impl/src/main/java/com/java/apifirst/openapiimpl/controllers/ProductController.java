package com.java.apifirst.openapiimpl.controllers;

import com.java.apifirst.model.GetAllProducts200ResponseInner;
import com.java.apifirst.openapiimpl.services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductsService productsService;

    @PostMapping("/v1/products")
    public ResponseEntity<String> createProduct(@RequestBody GetAllProducts200ResponseInner product) {
        GetAllProducts200ResponseInner createdProduct = productsService.createProduct(product);
        return ResponseEntity.created(UriComponentsBuilder.fromUriString("/v1/products/" + createdProduct.getId()).build().toUri()).build();
    }
}
