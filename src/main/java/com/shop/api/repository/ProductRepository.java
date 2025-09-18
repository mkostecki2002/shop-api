package com.shop.api.repository;

import com.shop.api.data.Product;
import com.shop.api.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findByCategory_Name(String categoryName);
}
