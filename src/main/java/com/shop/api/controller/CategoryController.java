package com.shop.api.controller;

import com.shop.api.dto.CategoryDto;
import com.shop.api.mapper.CategoryMapper;
import com.shop.api.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:5173")
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .toList();
    }

    @GetMapping("/featured")
    public ResponseEntity<List<CategoryDto>> getFeaturedCategories() {
        List<CategoryDto> result = categoryRepository.findByIsFeatured(true)
                .stream()
                .map(categoryMapper::toDto)
                .toList();
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
