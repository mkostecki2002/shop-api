package com.shop.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private UUID id;
    private String name;
    private String description;
    private Long price;
    private String image;
}
