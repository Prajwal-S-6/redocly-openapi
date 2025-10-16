package com.java.apifirst.openapiimpl;

import com.java.apifirst.model.GetAllCustomers200ResponseInner;
import com.java.apifirst.model.GetAllCustomers200ResponseInnerName;
import com.java.apifirst.model.GetAllCustomers200ResponseInnerPaymentMethodsInner;
import com.java.apifirst.model.GetAllCustomers200ResponseInnerShipToAddress;
import com.java.apifirst.openapiimpl.dao.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class OpenapiImplApplication implements CommandLineRunner {

    @Autowired
    CustomerRepositoryImpl customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(OpenapiImplApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println(" Test ");
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

        customerRepository.save(customers200ResponseInner);
        customerRepository.save(customers200ResponseInner1);
    }
}
