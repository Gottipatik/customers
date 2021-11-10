package com.customers.service.impl;

import com.customers.entity.CustomerEntity;
import com.customers.model.request.UpdateCustomerRequest;
import com.customers.repository.CustomerRepository;
import com.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<CustomerEntity> createCustomer(CustomerEntity customerEntity) {
        return Optional.ofNullable(customerRepository.save(customerEntity));
    }

    @Override
    public Optional<List<CustomerEntity>> findAllCustomers() {
        List<CustomerEntity> customers = customerRepository.findAll();
        return customers.isEmpty() ? Optional.empty() : Optional.of(customers);
    }

    @Override
    public Optional<CustomerEntity> findCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Integer deleteCustomerById(Long id) {
        return customerRepository.deleteCustomerById(id);
    }

    @Override
    public Optional<CustomerEntity> updateCustomerById(Long id, UpdateCustomerRequest updateCustomerRequest) {
        int count = customerRepository.updateCustomerById(updateCustomerRequest.getName(),
                updateCustomerRequest.getEmail(), updateCustomerRequest.getAge(), updateCustomerRequest.getPhoneNumber(), id);

        if(count > 0) {
            return Optional.of(new CustomerEntity(updateCustomerRequest.getName(),id,updateCustomerRequest.getAge(),
                    updateCustomerRequest.getEmail(),updateCustomerRequest.getPhoneNumber()));
        }

        return Optional.empty();
    }
}