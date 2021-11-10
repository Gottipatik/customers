package com.customers.repository;

import com.customers.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

    @Modifying
    @Query(value = "delete from customer where id = ?",nativeQuery = true)
    @Transactional
    int deleteCustomerById(Long id);

    @Modifying
    @Query(value = "update customer set name = ?, email = ?, age = ?, phone_number = ? where id = ?",nativeQuery = true)
    @Transactional
    int updateCustomerById(String name, String email, Integer age, String phoneNumber, Long id);
}
