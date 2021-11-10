package com.customers.controller.impl;

import com.customers.controller.CustomerController;
import com.customers.entity.CustomerEntity;
import com.customers.model.request.UpdateCustomerRequest;
import com.customers.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CustomerControllerImpl implements CustomerController {

    private final CustomerService customerService;

    public CustomerControllerImpl(CustomerService customerService){
        this.customerService = customerService;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity) {
       return customerService.createCustomer(customerEntity)
                .map(b->ResponseEntity.status(HttpStatus.CREATED).body(b))
               .orElse(ResponseEntity.internalServerError().build());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable("id") Long id) {
        return customerService.findCustomerById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id) {
        Integer count = customerService.deleteCustomerById(id);

        if(count>0){
            return ResponseEntity.ok().build();
        }
        return  ResponseEntity.notFound().build();
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        return customerService.findAllCustomers().map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable("id") Long id,
                                                         @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return customerService.updateCustomerById(id,updateCustomerRequest)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
