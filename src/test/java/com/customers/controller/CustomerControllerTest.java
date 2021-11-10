package com.customers.controller;

import com.customers.entity.CustomerEntity;
import com.customers.model.request.UpdateCustomerRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetCustomerById() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/v1/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Marvel"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("marvel@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value("888-888-8888"));


    }

    @Test
    public void testUpdateCustomer() throws Exception {

        UpdateCustomerRequest updateCustomerRequest = new UpdateCustomerRequest("Deadpool","deadpool@gmail.com",20,"999-999-9999");

        String body = objectMapper.writeValueAsString(updateCustomerRequest);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/v1/2")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(body);

        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Deadpool"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("deadpool@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value("999-999-9999"));


    }

    @Test
    public void testCreateCustomer() throws Exception {

        CustomerEntity customerEntity = new CustomerEntity("IronMan",10l,20,"ironman@gmail.com","555-555-5555");

        String body = objectMapper.writeValueAsString(customerEntity);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/v1/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(body);

        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("IronMan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("ironman@gmail.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(20))
                .andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumber").value("555-555-5555"));


    }

    @Test
    public void testDeleteCustomerById() throws Exception {

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.delete("/v1/4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
