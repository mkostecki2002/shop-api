package com.shop.api.controller;

import com.shop.api.data.Customer;
import com.shop.api.dto.CustomerDto;
import com.shop.api.mapper.CustomerMapper;
import com.shop.api.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> customers = customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto).toList();
        return customers;
    }
}
