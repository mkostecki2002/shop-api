package com.shop.api.mapper;

import com.shop.api.data.Category;
import com.shop.api.dto.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
    Category toEntity(CategoryDto dto);
}
