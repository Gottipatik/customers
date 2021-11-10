package com.customers.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "customer")
public class CustomerEntity {

    private String name;

    @Id
    private Long id;

    private Integer age;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerEntity(String name, Long id, Integer age, String email, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public CustomerEntity(){

    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
