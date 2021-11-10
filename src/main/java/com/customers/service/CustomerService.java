package com.customers.service;

import com.customers.entity.CustomerEntity;
import com.customers.model.request.UpdateCustomerRequest;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Optional<CustomerEntity> createCustomer(CustomerEntity customerEntity);

    Optional<List<CustomerEntity>> findAllCustomers();

    Optional<CustomerEntity> findCustomerById(Long id);

    Integer deleteCustomerById(Long id);

    Optional<CustomerEntity> updateCustomerById(Long id, UpdateCustomerRequest updateCustomerRequest);
}
