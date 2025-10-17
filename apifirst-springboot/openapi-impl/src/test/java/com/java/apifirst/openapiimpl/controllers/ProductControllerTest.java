package com.java.apifirst.openapiimpl.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.apifirst.model.GetAllProducts200ResponseInner;
import com.java.apifirst.openapiimpl.dao.ProductRepository;
import com.java.apifirst.openapiimpl.services.ProductsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Collections;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @MockitoBean
    private ProductsService productsService;

    @MockitoBean
    private ProductRepository productRepository;

    @Autowired
    private MockMvc mockMvc;

    GetAllProducts200ResponseInner product = new GetAllProducts200ResponseInner().builder()
            .id(new UUID(123, 456))
            .name("Product 1")
            .description("some product")
            .category("New")
            .price(45.33).build();

    @Test
    void shouldReturnStatusAs201WhenCreateProductIsCalled() throws Exception {
        when(productsService.createProduct(any())).thenReturn(product);
        mockMvc.perform(post("/v1/products").contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(product)))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnLocationOfNewlyCreatedProduct() throws Exception {
        when(productsService.createProduct(any())).thenReturn(product);
        MvcResult mvcResult = mockMvc.perform(post("/v1/products").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(product))).andReturn();


        String location = mvcResult.getResponse().getHeader("Location");
        assertThat(location).isEqualTo("/v1/products/00000000-0000-007b-0000-0000000001c8");
    }

    @Test
    void shouldReturnStatus200AndListOfProducts() throws Exception {
        when(productsService.getAllProducts()).thenReturn(Collections.singletonList(product));

        mockMvc.perform(get("/v1/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", equalTo(1)));
    }

}