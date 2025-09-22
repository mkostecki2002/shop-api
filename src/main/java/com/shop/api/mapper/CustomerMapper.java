package com.shop.api.mapper;

import com.shop.api.data.Customer;
import com.shop.api.data.Role;
import com.shop.api.dto.CustomerDto;
import com.shop.api.repository.CustomerRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "roles", expression = "java(mapAuthoritiesToString(customer.getAuthorities()))")
    CustomerDto toDto(Customer customer);

    default List<String> mapAuthoritiesToString(Collection<? extends GrantedAuthority> roles) {
        return roles.stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
    }

    @Mapping(target = "roles", ignore = true)
    Customer toEntity(CustomerDto customerDto);
}
