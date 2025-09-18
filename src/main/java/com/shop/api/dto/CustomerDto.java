package com.shop.api.dto;

import com.shop.api.data.Address;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Address address;
}
