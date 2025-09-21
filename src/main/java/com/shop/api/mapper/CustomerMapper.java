package com.shop.api.mapper;

import com.shop.api.data.Customer;
import com.shop.api.data.Role;
import com.shop.api.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "roles", expression = "java(mapAuthorities(customer.getAuthorities()))")
    CustomerDto toDto(Customer customer);

    default List<String> mapAuthorities(Collection<? extends GrantedAuthority> roles) {
        return roles.stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
    }

    Customer toEntity(CustomerDto customerDto);
}
