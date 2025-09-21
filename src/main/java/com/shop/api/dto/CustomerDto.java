package com.shop.api.dto;

import com.shop.api.data.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private Address address;
    private List<String> roles;

    public List<String> getRoles() {
        return roles;
    }
}
