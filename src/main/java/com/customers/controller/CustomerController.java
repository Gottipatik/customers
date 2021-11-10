package com.customers.controller;

import com.customers.entity.CustomerEntity;
import com.customers.model.request.UpdateCustomerRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerController {

    ResponseEntity<CustomerEntity> createCustomer(CustomerEntity customerEntity);

    ResponseEntity<CustomerEntity> getCustomerById(Long id);

    ResponseEntity<Void> deleteCustomerById(Long id);

    ResponseEntity<List<CustomerEntity>> getAllCustomers();

    ResponseEntity<CustomerEntity> updateCustomer(Long id, UpdateCustomerRequest updateCustomerRequest);
}
