package com.shop.api.controller;

import com.shop.api.dto.ProductDto;
import com.shop.api.mapper.ProductMapper;
import com.shop.api.repository.ProductRepository;
import com.shop.api.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/category/{categoryName}")
    List<ProductDto> getProductsByCategory(@PathVariable String categoryName) {
        return productService.getProductsByCategoryName(categoryName);
    }

    @GetMapping("/{id}")
    ProductDto getProductById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }
}
