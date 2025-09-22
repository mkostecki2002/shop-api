package com.shop.api.service;

import com.shop.api.data.Customer;
import com.shop.api.data.Role;
import com.shop.api.data.RoleName;
import com.shop.api.dto.AuthenticationResponse;
import com.shop.api.dto.CustomerDto;
import com.shop.api.dto.LoginRequest;
import com.shop.api.dto.RegisterRequest;
import com.shop.api.exception.PasswordValidationException;
import com.shop.api.exception.RoleNotFoundException;
import com.shop.api.exception.UserAlreadyExistsException;
import com.shop.api.mapper.CustomerMapper;
import com.shop.api.repository.CustomerRepository;
import com.shop.api.repository.RoleRepository;
import com.shop.api.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    public AuthenticationResponse login(LoginRequest loginRequest) throws AuthenticationException {
        if (loginRequest.getEmail() == null || loginRequest.getPassword() == null) {
            throw new BadCredentialsException("Invalid email or password");
        };
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        if (registerRequest.getEmail() == null || registerRequest.getPassword() == null || registerRequest.getConfirmPassword() == null) {
            throw new PasswordValidationException("Email or password is missing");
        }
        String password = registerRequest.getPassword();

        if (!password.equals(registerRequest.getConfirmPassword())) {
            throw new PasswordValidationException("Passwords do not match");
        }
        if (password.length() < 8) {
            throw new PasswordValidationException("Password must be at least 8 characters");
        }
        if (password.chars().noneMatch(Character::isUpperCase)) {
            throw new PasswordValidationException("Password must contain at least 1 uppercase letter");
        }
        if (password.chars().noneMatch(Character::isDigit)) {
            throw new PasswordValidationException("Password must contain at least 1 digit");
        }

        if ((long) customerRepository.findByEmail(registerRequest.getEmail()).size() == 1) {
            throw new UserAlreadyExistsException("User with email already exists");
        }

        CustomerDto customerDto = new CustomerDto();
        customerDto.setEmail(registerRequest.getEmail());
        customerDto.setPassword(password);
        customerDto.setFirstName(registerRequest.getFirstName());
        customerDto.setLastName(registerRequest.getLastName());
        customerDto.setRoles(List.of("USER"));
        if (registerRequest.getPhone() != null) {
            customerDto.setPhone(registerRequest.getPhone());
        }

        System.out.println(customerDto.getRoles());

        Customer customer = customerMapper.toEntity(customerDto);
        customer.setPassword(passwordEncoder.encode(password));
        List<Role> roles = customerDto.getRoles().stream()
                .map(r -> roleRepository.findByName(RoleName.valueOf(r)))
                .toList();
        if (roles.isEmpty()) {
            throw new RoleNotFoundException("Role not found in DB");
        }
        customer.setRoles(roles);
        customerRepository.save(customer);

        return new AuthenticationResponse(jwtService.generateToken(customer));
    }

}
