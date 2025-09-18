package com.shop.api.repository;

import com.shop.api.data.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    List<Customer> findAll();
    List<Customer> findByEmail(String email);
}
