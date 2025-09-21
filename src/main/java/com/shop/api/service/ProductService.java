package com.shop.api.service;

import com.shop.api.dto.ProductDto;
import com.shop.api.mapper.ProductMapper;
import com.shop.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream().
                map(productMapper::toDto).toList();
    }

    public List<ProductDto> getProductsByCategoryName(String categoryName) {
        return productRepository.findByCategory_Name(categoryName)
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    public ProductDto getProductById(UUID id) {
        return productRepository.findById(id).map(productMapper::toDto).orElseThrow();
    }
}
