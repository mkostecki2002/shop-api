package com.shop.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class ProductDto {
    private UUID id;
    private String name;
    private String description;
    private Long price;
    private String image;
}
