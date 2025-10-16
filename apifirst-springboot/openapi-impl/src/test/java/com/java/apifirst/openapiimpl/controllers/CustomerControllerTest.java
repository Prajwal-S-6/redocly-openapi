package com.java.apifirst.openapiimpl.controllers;

import com.java.apifirst.model.GetAllCustomers200ResponseInner;
import com.java.apifirst.model.GetAllCustomers200ResponseInnerName;
import com.java.apifirst.model.GetAllCustomers200ResponseInnerPaymentMethodsInner;
import com.java.apifirst.model.GetAllCustomers200ResponseInnerShipToAddress;
import com.java.apifirst.openapiimpl.dao.CustomerRepository;
import com.java.apifirst.openapiimpl.dao.CustomerRepositoryImpl;
import com.java.apifirst.openapiimpl.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CustomerService customerService;

    @MockitoBean
    private CustomerRepositoryImpl customerRepository;

    GetAllCustomers200ResponseInner customers200ResponseInner = new GetAllCustomers200ResponseInner()
            .builder()
            .id(new UUID(123, 456))
            .name(GetAllCustomers200ResponseInnerName.builder().firstName("Praj").lastName("S").build())
            .shipToAddress(GetAllCustomers200ResponseInnerShipToAddress.builder()
                    .line1("123 street")
                    .line2("London")
                    .country(GetAllCustomers200ResponseInnerShipToAddress.CountryEnum.IND).build())
            .billToAddress(GetAllCustomers200ResponseInnerShipToAddress.builder()
                    .line1("123 street")
                    .line2("London")
                    .country(GetAllCustomers200ResponseInnerShipToAddress.CountryEnum.IND).build())
            .email("abc@gmail.com")
            .paymentMethods(List.of(GetAllCustomers200ResponseInnerPaymentMethodsInner.builder()
                    .cardNumber(12345)
                    .expiryMonth(12)
                    .displayName("Prajwal")
                    .cvv(666)
                    .expiryYear(2026).build()))
            .build();

    GetAllCustomers200ResponseInner customers200ResponseInner1 = new GetAllCustomers200ResponseInner()
            .builder()
            .id(new UUID(1234, 4567))
            .name(GetAllCustomers200ResponseInnerName.builder().firstName("Sam").lastName("B").build())
            .shipToAddress(GetAllCustomers200ResponseInnerShipToAddress.builder()
                    .line1("1234 street")
                    .line2("Paris")
                    .country(GetAllCustomers200ResponseInnerShipToAddress.CountryEnum.IND).build())
            .billToAddress(GetAllCustomers200ResponseInnerShipToAddress.builder()
                    .line1("1234 street")
                    .line2("Paris")
                    .country(GetAllCustomers200ResponseInnerShipToAddress.CountryEnum.IND).build())
            .email("abcd@gmail.com")
            .paymentMethods(List.of(GetAllCustomers200ResponseInnerPaymentMethodsInner.builder()
                    .cardNumber(123456)
                    .expiryMonth(11)
                    .displayName("Sam")
                    .cvv(667)
                    .expiryYear(2027).build()))
            .build();

    @Test
    void shouldReturnListOfCustomers() throws Exception {
        when(customerService.getAllCustomers()).thenReturn(List.of(customers200ResponseInner1, customers200ResponseInner));
        mockMvc.perform(get("/v1/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", equalTo(2)));
    }

    @Test
    void shouldReturnEmptyListWhenNoCustomers() throws Exception {
        mockMvc.perform(get("/v1/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", equalTo(0)));
    }

    @Test
    void shouldReturnCustomerByID() throws Exception {
        when(customerService.getCustomerById(any())).thenReturn(customers200ResponseInner);

        mockMvc.perform(get("/v1/customer/{id}", new UUID(123, 4556)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name.firstName", is("Praj")))
                .andExpect(jsonPath("$.name.lastName", is("S")));
    }
}