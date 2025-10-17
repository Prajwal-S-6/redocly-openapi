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
public class OpenapiImplApplication {


    public static void main(String[] args) {
        SpringApplication.run(OpenapiImplApplication.class, args);
    }
}
