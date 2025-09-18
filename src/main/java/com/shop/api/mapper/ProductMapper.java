package com.shop.api.mapper;

import com.shop.api.data.Product;
import com.shop.api.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto toDto(Product product);
    Product toEntity(ProductDto productDto);
}
