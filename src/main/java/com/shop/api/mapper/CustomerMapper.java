package com.shop.api.mapper;

import com.shop.api.data.Customer;
import com.shop.api.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toDto(Customer customer);
    Customer toEntity(CustomerDto customerDto);
}
